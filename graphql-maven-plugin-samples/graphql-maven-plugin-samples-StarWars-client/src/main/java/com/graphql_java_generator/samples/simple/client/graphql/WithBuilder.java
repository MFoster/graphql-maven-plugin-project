/**
 * 
 */
package com.graphql_java_generator.samples.simple.client.graphql;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import com.generated.graphql.Character;
import com.generated.graphql.Droid;
import com.generated.graphql.Episode;
import com.generated.graphql.Human;
import com.generated.graphql.MutationType;
import com.generated.graphql.QueryType;
import com.graphql_java_generator.client.request.Builder;
import com.graphql_java_generator.client.request.ObjectResponse;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;
import com.graphql_java_generator.samples.simple.client.Queries;

/**
 * This class implements the away to call GraphQl queries, where all queries are prepared before execution.<BR/>
 * The advantages are:
 * <UL>
 * <LI>Performance: this avoid to build an {@link ObjectResponse} for each response. This {@link ObjectResponse} is
 * useful, to help control at runtime if a field has been queried or not. It allows to throw an exception when your code
 * tries to use a field that was not queried</LI>
 * <LI>Security: as all request have been prepared at startup, this make sure at startup that your queries are
 * valid.</LI>
 * </UL>
 * 
 * @author EtienneSF
 */
public class WithBuilder implements Queries {

	final QueryType queryType;
	final MutationType mutationType;

	ObjectResponse heroFullResponse;
	ObjectResponse heroPartialResponse;
	ObjectResponse heroFriendsFriendsFriendsResponse;

	ObjectResponse humanFullResponse;
	ObjectResponse humanPartialResponse;
	ObjectResponse humanFriendsFriendsFriendsResponse;

	ObjectResponse droidFullResponse;
	ObjectResponse droidPartialResponse;
	ObjectResponse droidFriendsFriendsFriendsResponse;

	ObjectResponse droidDoesNotExist;

	ObjectResponse createHuman;
	ObjectResponse addFriend;

	/**
	 * This constructor expects the URI of the GraphQL server. This constructor works only for http servers, not for
	 * https ones.<BR/>
	 * For example: https://my.server.com/graphql
	 * 
	 * @param graphqlEndpoint
	 *            the https URI for the GraphQL endpoint
	 * @param sslContext
	 * @param hostnameVerifier
	 * @throws GraphQLRequestPreparationException
	 */
	public WithBuilder(String graphqlEndpoint, SSLContext sslContext, HostnameVerifier hostnameVerifier)
			throws GraphQLRequestPreparationException {
		queryType = new QueryType(graphqlEndpoint, sslContext, hostnameVerifier);
		mutationType = new MutationType(graphqlEndpoint, sslContext, hostnameVerifier);

		//////////////////////////////////////////////////////////////////////////////////////////////////
		// Hero

		// The easiest way: don't precise which fields you want, and all known scalar fields are queried
		heroFullResponse = queryType.getHeroResponseBuilder().build();

		// Of course, you can precise the fields you want
		// {appearsIn name}
		heroPartialResponse = queryType.getHeroResponseBuilder().withField("appearsIn").withField("name").build();

		// Of course, you can precise the fields you want
		// {id appearsIn friends {name friends {friends{id name appearsIn}}}}
		ObjectResponse friends3 = new Builder(Character.class, "friends").withField("id").withField("name")
				.withField("appearsIn").build();
		ObjectResponse friends2 = new Builder(Character.class, "friends").withSubObject(friends3).build();
		ObjectResponse characterFriends1 = new Builder(Character.class, "friends").withField("name")
				.withSubObject(friends2).build();
		heroFriendsFriendsFriendsResponse = queryType.getHeroResponseBuilder().withField("id").withField("appearsIn")
				.withSubObject(characterFriends1).build();

		//////////////////////////////////////////////////////////////////////////////////////////////////
		// Human

		// The easiest way: don't precise which fields you want, and all known scalar fields are queried
		humanFullResponse = queryType.getHumanResponseBuilder().build();

		// Of course, you can precise the fields you want
		// {appearsIn homePlanet name}
		humanPartialResponse = queryType.getHumanResponseBuilder().withField("appearsIn").withField("homePlanet")
				.withField("name").build();

		// Of course, you can precise the fields you want
		// {id appearsIn name friends{name friends{friends{id name appearsIn}}}}
		ObjectResponse humanFriends1 = new Builder(Human.class, "friends").withField("name").withSubObject(friends2)
				.build();
		humanFriendsFriendsFriendsResponse = queryType.getHumanResponseBuilder().withField("id").withField("appearsIn")
				.withField("name").withSubObject(humanFriends1).build();

		//////////////////////////////////////////////////////////////////////////////////////////////////
		// Droid

		// The easiest way: don't precise which fields you want, and all known scalar fields are queried
		droidFullResponse = queryType.getDroidResponseBuilder().build();

		// Of course, you can precise the fields you want
		// {appearsIn primaryFunction name}
		droidPartialResponse = queryType.getDroidResponseBuilder().withField("appearsIn").withField("primaryFunction")
				.withField("name").build();

		// Of course, you can precise the fields you want
		// {id appearsIn name friends{name friends{friends{id name appearsIn}}}primaryFunction}
		ObjectResponse droidFriends1 = new Builder(Droid.class, "friends").withField("name").withSubObject(friends2)
				.build();
		droidFriendsFriendsFriendsResponse = queryType.getDroidResponseBuilder().withField("id").withField("appearsIn")
				.withField("name").withSubObject(droidFriends1).withField("primaryFunction").build();

		//////////////////////////////////////////////////////////////////////////////////////////////////
		// A demo of a wrong query. The preparation below should fail.
		// In real code, this would throw an exception to the caller
		// But here, we want the code to go on. So we just check to confirm that the exception occurs, and actually hide
		// it.
		try {
			queryType.getDroidResponseBuilder().withField("id").withField("appearsIn").withField("NON_EXISTING_FIELD")
					.withSubObject(droidFriends1).withField("primaryFunction").build();

			// Oups, if we got there, the expected exception was not thrown. Which means that the sample failed.
			// Let's throw an exception to block the execution (as the Maven build executes this sample, this will hang
			// the build)
			throw new RuntimeException("The query with the NON_EXISTING_FIELD should have thrown a "
					+ GraphQLRequestPreparationException.class.getName()
					+ " exception, but no exception was thrown (in " + this.getClass().getName() + ")");
		} catch (GraphQLRequestPreparationException e) {
			// This what's expected. So, no further action ... as we're in a sample !
		}

		// Mutations
		createHuman = mutationType.getCreateHumanResponseBuilder().build();
		addFriend = mutationType.getAddFriendResponseBuilder().withField("id").withField("name").withField("appearsIn")
				.withSubObject(new Builder(Character.class, "friends").build()).build();
	}

	@Override
	public Character heroFull() throws GraphQLRequestExecutionException {
		return queryType.hero(heroFullResponse, null);
	}

	@Override
	public Character heroPartial(Episode episode) throws GraphQLRequestExecutionException {
		return queryType.hero(heroPartialResponse, episode);
	}

	@Override
	public Character heroFriendsFriendsFriends(Episode episode) throws GraphQLRequestExecutionException {
		return queryType.hero(heroFriendsFriendsFriendsResponse, episode);
	}

	@Override
	public Human humanFull(String id) throws GraphQLRequestExecutionException {
		return queryType.human(humanFullResponse, id);
	}

	@Override
	public Human humanPartial(String id) throws GraphQLRequestExecutionException {
		return queryType.human(humanPartialResponse, id);
	}

	@Override
	public Human humanFriendsFriendsFriends(String id) throws GraphQLRequestExecutionException {
		return queryType.human(humanFriendsFriendsFriendsResponse, id);
	}

	@Override
	public Droid droidFull(String id) throws GraphQLRequestExecutionException {
		return queryType.droid(droidFullResponse, id);
	}

	@Override
	public Droid droidPartial(String id) throws GraphQLRequestExecutionException {
		return queryType.droid(droidPartialResponse, id);
	}

	@Override
	public Droid droidFriendsFriendsFriends(String id) throws GraphQLRequestExecutionException {
		return queryType.droid(droidFriendsFriendsFriendsResponse, id);
	}

	@Override
	public Droid droidDoesNotExist() throws GraphQLRequestExecutionException {
		return queryType.droid(droidFriendsFriendsFriendsResponse, "00000000-0000-0000-0000-000000001111");
	}

	@Override
	public Human createHuman(String name, String homePlanet)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		return mutationType.createHuman(createHuman, name, homePlanet);
	}

	@Override
	public Character addFriend(String idCharacter, String idNewFriend)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		return mutationType.addFriend(addFriend, idCharacter, idNewFriend);
	}

}