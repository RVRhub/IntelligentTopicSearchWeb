package com.intelligent.topic.search.domain;

import java.io.Serializable;
import java.util.List;

public class Documents implements Serializable {
	private List<DocumentImpl> documents;

	public Documents() {
	}

	public Documents(List<DocumentImpl> documents) {
		this.documents = documents;
	}

	public List<DocumentImpl> getDocuments() {

		return documents;
	}

	public void setDocuments(List<DocumentImpl> documents) {
		this.documents = documents;
	}

}
