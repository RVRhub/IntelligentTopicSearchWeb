package com.intelligent.topic.search.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.intelligent.topic.search.domain.DocumentImpl;
import com.intelligent.topic.search.repository.DocumentsRepository;
import com.intelligent.topic.search.service.DocumentService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shredinger
 * Date: 10/18/13
 * Time: 12:31 AM
 * Project: IntelligentSearch
 */
@Service("documentService")
@Repository
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private DocumentsRepository documentsRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;


	@Override
	public List<DocumentImpl> findAll() {
		return Lists.newArrayList(documentsRepository.findAll());
	}

    @Override
    public List<DocumentImpl> getDocumentsByTopic(int topic, int limit) {
        return mongoTemplate.find(new Query().with(new Sort(Sort.Direction.DESC, "topicsDistribution." + topic)).limit(limit),
                DocumentImpl.class);
    }
}
