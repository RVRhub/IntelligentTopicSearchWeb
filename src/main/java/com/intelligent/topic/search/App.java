package com.intelligent.topic.search;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;


import com.intelligent.topic.search.domain.DocumentImpl;


public class App {

    public static void main(String[] args) {


        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:applicationContext.xml");
        ctx.refresh();

        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        System.out.println(mongoOperation.toString());

        List<DocumentImpl> listUser = mongoOperation.findAll(DocumentImpl.class);
        System.out.println("4. Number of user = " + listUser.size());

    }

}