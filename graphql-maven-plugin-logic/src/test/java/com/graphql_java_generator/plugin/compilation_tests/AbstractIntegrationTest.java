package com.graphql_java_generator.plugin.compilation_tests;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import com.graphql_java_generator.plugin.CodeGenerator;
import com.graphql_java_generator.plugin.DocumentParser;
import com.graphql_java_generator.plugin.PluginConfiguration;
import com.graphql_java_generator.plugin.test.compiler.CompilationTestHelper;
import com.graphql_java_generator.plugin.test.helper.GraphqlTestHelper;
import com.graphql_java_generator.plugin.test.helper.MavenTestHelper;

@DirtiesContext // We need to forget the previous parsing (or everything may be doubled)
abstract class AbstractIntegrationTest {

	@Autowired
	protected ApplicationContext ctx;
	@Autowired
	protected CompilationTestHelper compilationTestHelper;
	@Autowired
	protected GraphqlTestHelper graphqlTestHelper;
	@Autowired
	protected MavenTestHelper mavenTestHelper;

	@Resource
	PluginConfiguration pluginConfiguration;

	@javax.annotation.Resource
	protected DocumentParser documentParser;
	@javax.annotation.Resource
	protected CodeGenerator codeGenerator;

	/**
	 * This test will be executed for each concrete subclass of this class
	 * 
	 * @throws MojoExecutionException
	 * @throws IOException
	 */
	@Test
	@DirtiesContext // We need to forget the previous parsing (or everything may be doubled)
	void testGenerateCode() throws IOException {
		// Preparation
		int i = documentParser.parseDocuments();

		mavenTestHelper.deleteDirectoryAndContentIfExists(pluginConfiguration.getTargetSourceFolder());
		mavenTestHelper.deleteDirectoryAndContentIfExists(pluginConfiguration.getTargetClassFolder());

		// Go, go, go
		codeGenerator.generateCode();

		compilationTestHelper.checkCompleteCompilationStatus(null);
	}

}
