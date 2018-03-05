package com.learn.solrj.connection;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ConnectingToSolar {
    final String solrUrl = "http://localhost:8983/solr";
    @Test
    public void httpConnect() throws SolrServerException, IOException {
        final SolrClient client = getHttpClient();

        final Map<String, String> queryParamMap = new HashMap<String, String>();
        queryParamMap.put("q", "*:*");
        queryParamMap.put("fl", "id, name");
        MapSolrParams queryParams = new MapSolrParams(queryParamMap);

        final QueryResponse response = client.query("techproducts", queryParams);
        final SolrDocumentList documents = response.getResults();

        //assertEquals(NUM_INDEXED_DOCUMENTS, documents.getNumFound());
        for(SolrDocument document : documents) {
            assertTrue(document.getFieldNames().contains("id"));
            //assertTrue(document.getFieldNames().contains("name"));
        }
    }

    private SolrClient getHttpClient() {
        return new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
    }
}
