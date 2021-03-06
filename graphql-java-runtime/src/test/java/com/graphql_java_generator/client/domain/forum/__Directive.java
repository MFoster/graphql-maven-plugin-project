package com.graphql_java_generator.client.domain.forum;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLScalar;

import java.util.Date;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */

public class __Directive  {

	@JsonProperty("name")
	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	String name;


	@JsonProperty("description")
	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	String description;


	@JsonProperty("locations")
	@JsonDeserialize(contentAs = __DirectiveLocation.class)
	@GraphQLScalar(graphQLTypeName = "__DirectiveLocation", javaClass = __DirectiveLocation.class)
	List<__DirectiveLocation> locations;


	@JsonProperty("args")
	@JsonDeserialize(contentAs = __InputValue.class)
	@GraphQLNonScalar(graphQLTypeName = "__InputValue", javaClass = __InputValue.class)
	List<__InputValue> args;


	@JsonProperty("isRepeatable")
	@GraphQLScalar(graphQLTypeName = "Boolean", javaClass = Boolean.class)
	Boolean isRepeatable;


	@JsonProperty("__typename")
	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	String __typename;



	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setLocations(List<__DirectiveLocation> locations) {
		this.locations = locations;
	}

	public List<__DirectiveLocation> getLocations() {
		return locations;
	}

	public void setArgs(List<__InputValue> args) {
		this.args = args;
	}

	public List<__InputValue> getArgs() {
		return args;
	}

	public void setIsRepeatable(Boolean isRepeatable) {
		this.isRepeatable = isRepeatable;
	}

	public Boolean getIsRepeatable() {
		return isRepeatable;
	}

	public void set__typename(String __typename) {
		this.__typename = __typename;
	}

	public String get__typename() {
		return __typename;
	}

    public String toString() {
        return "__Directive {"
				+ "name: " + name
				+ ", "
				+ "description: " + description
				+ ", "
				+ "locations: " + locations
				+ ", "
				+ "args: " + args
				+ ", "
				+ "isRepeatable: " + isRepeatable
				+ ", "
				+ "__typename: " + __typename
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field {
		Name("name"),
		Description("description"),
		Locations("locations"),
		Args("args"),
		IsRepeatable("isRepeatable"),
		__typename("__typename");

		private String fieldName;

		Field(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getFieldName() {
			return fieldName;
		}

	}
}
