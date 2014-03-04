package com.intelligent.topic.search.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.intelligent.topic.search.domain.DocumentImpl;


/**
 * Created with IntelliJ IDEA.
 * User: shredinger
 * Date: 10/13/13
 * Time: 9:06 PM
 * Project: IntelligentSearch
 */
public interface DocumentsRepository extends MongoRepository<DocumentImpl, Integer>{
}
