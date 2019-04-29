package com.reportscollector.reportcollector.config.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoDbConfig extends AbstractMongoConfiguration {

    @Autowired
    private MongoDbFactory mongoDbFactory;



    @Override
    protected String getDatabaseName() {
        return "heroku_gqns3x5c";
    }

    @Override
    public MongoClient mongoClient() {
        String host = "ds147946.mlab.com";
        int port=47946;
        String username="heroku_gqns3x5c";
        String database="heroku_gqns3x5c";
        String s = "7335qkjkff7fci12kuetuetsh1";
        char [] password = s.toCharArray();
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(MongoCredential.createScramSha1Credential(username, database, password));
        ServerAddress server=new ServerAddress(host,port);
        MongoClient client = new MongoClient(server,credentials);
        return client;
    }
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, getDefaultMongoConverter());
        return mongoTemplate;
    }

    @Bean
    public MongoConverter getDefaultMongoConverter() {
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), new MongoMappingContext());
        converter.afterPropertiesSet();

        return converter;
    }
}
