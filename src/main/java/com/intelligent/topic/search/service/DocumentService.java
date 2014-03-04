package com.intelligent.topic.search.service;



import java.util.List;


import com.intelligent.topic.search.domain.DocumentImpl;

/**
 * Created with IntelliJ IDEA.
 * User: shredinger
 * Date: 10/18/13
 * Time: 12:29 AM
 * Project: IntelligentSearch
 */
public interface DocumentService {
	List<DocumentImpl> findAll();
}
