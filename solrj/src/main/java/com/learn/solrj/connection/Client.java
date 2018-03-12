package com.learn.solrj.connection;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class Client {
    private static String localSolrUrl = "http://localhost:8983/solr";
    private static String localCoursesSolrUrl = "http://localhost:8983/solr/courses/";
    private static SolrClient getHttpClient(String solrUrl) {
        return new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
    }
    public static  SolrClient connectToLocal() {
        return getHttpClient(localSolrUrl);
    }
    public static  SolrClient connectToLocalCourses() {
        return getHttpClient(localCoursesSolrUrl);
    }
}
