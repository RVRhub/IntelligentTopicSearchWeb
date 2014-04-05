package com.intelligent.topic.search.web.restful.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.intelligent.topic.search.domain.DocumentImpl;
import com.intelligent.topic.search.domain.Documents;
import com.intelligent.topic.search.service.DocumentService;

@Controller
@RequestMapping(value="/document")
public class DocumentController 
{

	final Logger logger = LoggerFactory.getLogger(DocumentController.class);
	
	@Autowired
	private DocumentService documentService;
	
	@RequestMapping(value="/listdata", method=RequestMethod.GET)
	@ResponseBody
	public Documents listData()
	{
		logger.info("listData");
		return new Documents(documentService.findAll());
	}
	
	@RequestMapping(value="/listdatafirst", method=RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public 	 DocumentImpl listDataFirst()
	{
		logger.info("listDataFirst");
		return documentService.findAll().get(0);
	}

    @RequestMapping(value="/{topic}", method=RequestMethod.GET)
    @ResponseBody
    public Documents listTopic(@PathVariable Integer topic)
    {
        return new Documents(documentService.getDocumentsByTopic(topic, 2));
    }

	
	@RequestMapping(value="/notes", method=RequestMethod.GET)
	public void jsonpCallback(@RequestParam("callback") String callback, HttpServletResponse response) throws IOException {
	   response.setContentType("text/javascript; charset=UTF-8");
	   PrintWriter out = response.getWriter();
	   out.print(callback + "("+  documentService.findAll().get(0)+	")");
	}
	
}
