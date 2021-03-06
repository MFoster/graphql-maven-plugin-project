package com.graphql_java_generator.client.domain.starwars;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLScalar;


/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */

public class __Type  {

	@JsonProperty("kind")
	@GraphQLScalar(graphQLTypeName = "__TypeKind", javaClass = __TypeKind.class)
	__TypeKind kind;


	@JsonProperty("name")
	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	String name;


	@JsonProperty("description")
	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	String description;


	@GraphQLInputParameters(names = {"includeDeprecated"}, types = {"Boolean"})
	@JsonProperty("fields")
	@JsonDeserialize(contentAs = __Field.class)
	@GraphQLNonScalar(graphQLTypeName = "__Field", javaClass = __Field.class)
	List<__Field> fields;


	@JsonProperty("interfaces")
	@JsonDeserialize(contentAs = __Type.class)
	@GraphQLNonScalar(graphQLTypeName = "__Type", javaClass = __Type.class)
	List<__Type> interfaces;


	@JsonProperty("possibleTypes")
	@JsonDeserialize(contentAs = __Type.class)
	@GraphQLNonScalar(graphQLTypeName = "__Type", javaClass = __Type.class)
	List<__Type> possibleTypes;


	@GraphQLInputParameters(names = {"includeDeprecated"}, types = {"Boolean"})
	@JsonProperty("enumValues")
	@JsonDeserialize(contentAs = __EnumValue.class)
	@GraphQLNonScalar(graphQLTypeName = "__EnumValue", javaClass = __EnumValue.class)
	List<__EnumValue> enumValues;


	@JsonProperty("inputFields")
	@JsonDeserialize(contentAs = __InputValue.class)
	@GraphQLNonScalar(graphQLTypeName = "__InputValue", javaClass = __InputValue.class)
	List<__InputValue> inputFields;


	@JsonProperty("ofType")
	@GraphQLNonScalar(graphQLTypeName = "__Type", javaClass = __Type.class)
	__Type ofType;


	@JsonProperty("__typename")
	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	String __typename;



	public void setKind(__TypeKind kind) {
		this.kind = kind;
	}

	public __TypeKind getKind() {
		return kind;
	}

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

	public void setFields(List<__Field> fields) {
		this.fields = fields;
	}

	public List<__Field> getFields() {
		return fields;
	}

	public void setInterfaces(List<__Type> interfaces) {
		this.interfaces = interfaces;
	}

	public List<__Type> getInterfaces() {
		return interfaces;
	}

	public void setPossibleTypes(List<__Type> possibleTypes) {
		this.possibleTypes = possibleTypes;
	}

	public List<__Type> getPossibleTypes() {
		return possibleTypes;
	}

	public void setEnumValues(List<__EnumValue> enumValues) {
		this.enumValues = enumValues;
	}

	public List<__EnumValue> getEnumValues() {
		return enumValues;
	}

	public void setInputFields(List<__InputValue> inputFields) {
		this.inputFields = inputFields;
	}

	public List<__InputValue> getInputFields() {
		return inputFields;
	}

	public void setOfType(__Type ofType) {
		this.ofType = ofType;
	}

	public __Type getOfType() {
		return ofType;
	}

	public void set__typename(String __typename) {
		this.__typename = __typename;
	}

	public String get__typename() {
		return __typename;
	}

    public String toString() {
        return "__Type {"
				+ "kind: " + kind
				+ ", "
				+ "name: " + name
				+ ", "
				+ "description: " + description
				+ ", "
				+ "fields: " + fields
				+ ", "
				+ "interfaces: " + interfaces
				+ ", "
				+ "possibleTypes: " + possibleTypes
				+ ", "
				+ "enumValues: " + enumValues
				+ ", "
				+ "inputFields: " + inputFields
				+ ", "
				+ "ofType: " + ofType
				+ ", "
				+ "__typename: " + __typename
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field {
		Kind("kind"),
		Name("name"),
		Description("description"),
		Fields("fields"),
		Interfaces("interfaces"),
		PossibleTypes("possibleTypes"),
		EnumValues("enumValues"),
		InputFields("inputFields"),
		OfType("ofType"),
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
