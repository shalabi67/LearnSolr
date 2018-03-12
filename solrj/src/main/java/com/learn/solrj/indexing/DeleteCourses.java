package com.learn.solrj.indexing;

import com.learn.solrj.connection.Client;
import com.learn.solrj.model.Course;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;

import java.io.IOException;

public class DeleteCourses {
    public static void main(String[] args) throws IOException, SolrServerException {
        System.out.println("delete all documents from courses.");

        SolrClient client = Client.connectToLocalCourses();

        client.deleteByQuery("*:*");
        client.commit();
    }
}
