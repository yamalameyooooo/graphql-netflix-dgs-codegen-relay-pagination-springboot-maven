# Spring Boot Maven Netflix DGS GraphQL Codegen + Relay Pagination

A step by step guide to integrate codegen with pagination

## Generating Base Project

Generate a Spring Boot maven java 17 project with dependencies Springweb and Lombok from [https://start.spring.io/](https://start.spring.io/)

## IDE Plugins (IntelliJ Idea)

Add Netflix DGS plugins to IDE
[https://plugins.jetbrains.com/plugin/17852-dgs](https://plugins.jetbrains.com/plugin/17852-dgs)
[https://plugins.jetbrains.com/plugin/12465-dgt-codegen](https://plugins.jetbrains.com/plugin/12465-dgt-codegen)
Or search it in the IDE marketplace for “DGS” & “DGT-Codegen”

## Dependencies

    <dependencyManagement>
	    <dependencies>
		    <dependency>
			    <groupId>com.netflix.graphql.dgs</groupId>
			    <artifactId>graphql-dgs-platform-dependencies</artifactId>
			    <version>6.0.1</version>
			    <type>pom</type>
			    <scope>import</scope>
		    </dependency>
	    </dependencies>
    </dependencyManagement>

    <dependency>
	    <groupId>com.netflix.graphql.dgs</groupId>
	    <artifactId>graphql-dgs-spring-boot-starter</artifactId>
    </dependency>

    <dependency>
	    <groupId>com.netflix.graphql.dgs</groupId>
	    <artifactId>graphql-dgs-pagination</artifactId>
    </dependency>

## Schema.graphqls

Add schema file in path `“resources/graphql/”`. If the path doesn't exist create the graphql folder under the resources folder and place the file.

Make sure the contents of the .graphqls files are correct and without any typos.

## Codegen Plugin Configuration

This plugin is built by a community member “[deweyjose](https://github.com/deweyjose/graphqlcodegen)” and it is a port out from the official Netflix DGS Gradle plugin [click here](https://netflix.github.io/dgs/generating-code-from-schema/) for more info.

    <plugin>
	    <groupId>io.github.deweyjose</groupId>
	    <artifactId>graphqlcodegen-maven-plugin</artifactId>
	    <version>1.18</version>
	    <executions>
		    <execution>
			    <goals>
				    <goal>generate</goal>
			    </goals>
		    </execution>
	    </executions>
	    <configuration>
		    <subPackageNameDatafetchers>graph.query</subPackageNameDatafetchers>
		    <subPackageNameTypes>graph.schema</subPackageNameTypes>
		    <schemaPaths>
			    <param>src/main/resources/graphql/schema.graphqls</param>
		    </schemaPaths>
		    <typeMapping>
			    <MessageConnection>graphql.relay.SimpleListConnection&lt;Message&gt;</MessageConnection>
		    </typeMapping>
		    <packageName>com.shamsu.codegenpoc</packageName>
		    <outputDir>${project.build.directory}</outputDir>
	    </configuration>
    </plugin>

Note: those Types having `@connection` annotation in the schema file, in configuration we need to put them under `<typeMapping></typeMapping>` tag as shown above for Type `Message`.

This ensures that while codegen is running, it will create the relay file in runtime for those 2 Types.

## Properties or yml file

Add these properties to yml:

    dgs:
    	graphql:
    		schema-locations:
    			- "classpath*:graphql/**/*.graphql*"

## Maven command

Run this maven command to generate the files by using codegen:

    graphqlcodegen:generate -f pom.xml

Or
Go to maven->Plugins->graphqlcodegen->expand and run the maven “graphqlcodegen:generate”

## Generated files

After a successful build you can see the generated java files and dataFetchers files created based on schema provided in the `resources/ghaphql` folder and in the configuration provided in the `pom.xml` file inside tag `<schemaPaths>` are generated under the target folder.

For development process one can copy these generated files under `src/main/java/com/shamsu/codegenPOC/graph/schema||query||mutation` and place `DgsConstants.java` in the `src/main/java/com/shamsu/codegenPOC/` path.

## Logic and data layer implementation


Implement the datafetcher files as per the requirement, add DB connections and complete the generated methods present in the Datafetcher files.

## Running the project

Run the project as a Spring boot application, it should start a local Tomcat server at port ‘8080’.

Open [http://localhost:8080/graphiql](http://localhost:8080/graphiql) and test any desired query.
