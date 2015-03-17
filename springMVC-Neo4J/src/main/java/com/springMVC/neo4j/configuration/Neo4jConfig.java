package com.springMVC.neo4j.configuration;
import javax.annotation.Resource;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;


@Configuration
@PropertySource(value="classpath:/properties/database.properties")
@EnableNeo4jRepositories(basePackages="com.springMVC.neo4j.repositories")
public class Neo4jConfig extends Neo4jConfiguration {
	
	@Resource
	public Environment env;

	public Neo4jConfig() {
		setBasePackage("com.springMVC.neo4j.repositories");
	}
	
    @Bean
    public GraphDatabaseService graphDatabaseService() {
    	return new GraphDatabaseFactory().newEmbeddedDatabase(env.getProperty("db.location"));
    }
    
}