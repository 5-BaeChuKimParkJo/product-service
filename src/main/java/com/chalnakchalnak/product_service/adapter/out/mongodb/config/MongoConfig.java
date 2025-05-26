package com.chalnakchalnak.product_service.adapter.out.mongodb.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "com.chalnakchalnak.product-service.adaptor.out.mongodb.repository")
public class MongoConfig {
}