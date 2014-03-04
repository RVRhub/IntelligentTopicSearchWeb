package com.intelligent.topic.search.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shredinger
 * Date: 10/2/13
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */

@Document(collection = "document")
public class DocumentImpl implements Serializable {

    public DocumentImpl(int identifier, String title, double[] topicsDistribution) {
        this.identifier = identifier;
        this.title = title;
        this.topicsDistribution = topicsDistribution;
    }

    @Id
    private int identifier;

    public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setTopicsDistribution(double[] topicsDistribution) {
		this.topicsDistribution = topicsDistribution;
	}

	private String title;
    private String url;
    private double[] topicsDistribution;

   
    public int getIdentifier() {
        return identifier;
    }


    public String getTitle() {
        return title;
    }

    
    public String getUrl() {
        return url == null ? "Undefined" : url;
    }

    
    public void setUrl(String url) {
        this.url = url;
    }

   
    public double[] getTopicsDistribution() {
        return topicsDistribution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentImpl document = (DocumentImpl) o;

        if (identifier != document.identifier) return false;
        if (!title.equals(document.title)) return false;
        if (!Arrays.equals(topicsDistribution, document.topicsDistribution)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = identifier;
        result = 31 * result + title.hashCode();
        result = 31 * result + Arrays.hashCode(topicsDistribution);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "\"identifier\":" + identifier +
                ", \"title\": \"" + title + "\"" +
                ", \"topicsDistribution\":" + Arrays.toString(topicsDistribution) +
                '}';
    }
    
    
}
