Here are the next tasks listed, as a TODO list:
* Directives: add (and test) the standard directives (@skip, @include and @deprecated)
* it seems that @GraphQLCustomScalar annotation is used in the Post hard-coded test POJO to identify a custom scalar; but this annotation is no longer used in the generation of POJOs. I the Post class may need updating to use @GraphQLScalar instead unless I am missing something.
* enum values may currently not be a java keyword (seems to be a graphql-java limitation). issue to raise in the graphql-java project
* Add tests for unions
* Check compatibility with the schema.public.graphqls (available in the plugin logic test resources folder)
* Check compatibility with the shopify (available in the plugin logic test resources folder)
* Builder.withInputParameter(InputParameter) to be replaced by Builder.withInputParameter(String, String, boolean)
* Check InputObjectType with fields that are lists
* Manage directives (https://www.apollographql.com/docs/graphql-tools/schema-directives/)
* Document generateJPAAnnotation 
* Link with the maven generated plugin documentation
* Check query method returning a scalar (forum schema is ready for that)
* Check scalar field of regular Type, having input parameters (forum schema is ready for that)
* Parsing the Query request for Query Preparation should directly call the Builder (instead of creating the QueryField array, then calling the Builder)
* Subscriptions. Currently, GraphQL Java Generator manages queries and mutations.
* Add a gradle plugin (work in progress)
* Comments should be reported in the generated code, especially the POJOs and the queries, mutations and subscriptions
* Fragment in graphql queries
* The plugin currently manages only one GraphQL schema file. It would be nice to allow several graphqls files, with a pattern like /*.graphqls