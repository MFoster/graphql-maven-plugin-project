package com.graphql_java_generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation marks all fields in the generated classes, that are non scalar. That is: this class is either an
 * input type, or a standard GraphQL object.<BR/>
 * The {@link #javaClass()} contains the type for this Scalar. This is useful only when this field is actually a list,
 * as java has the type erasure shit, and on Runtime, you can use java reflection to check the objects allowed in the
 * list.
 * 
 * @author EtienneSF
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface GraphQLNonScalar {

	/**
	 * The name of the Custom Scalar type, as defined in the GraphQL schema. This name is used to retrieve the
	 * associated converter, on runtime
	 */
	public String graphQLTypeName();

	/** Contains the java data type that is has used to store the data, on both the client and the server side. */
	public Class<?> javaClass();

}
