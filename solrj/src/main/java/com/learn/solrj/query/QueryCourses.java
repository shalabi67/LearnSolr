package com.learn.solrj.query;

import com.learn.solrj.connection.Client;
import com.learn.solrj.model.Course;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;

import java.io.IOException;
import java.util.List;

/*
see Creating schem core
in the notes to create courses core.

before you start delete all documents by running:
curl http://localhost:8983/solr/courses/update?commit=true -H "Content-Type: text/xml" --data-binary "<delete><query>*:*</query></delete>"

 */
public class QueryCourses {
    public static void main(String[] args) throws IOException, SolrServerException {
        System.out.println("adding documents to courses.");

        SolrClient client = Client.connectToLocalCourses();

        SolrQuery query = create(QueryType.JiraAgileScrum);
        query.setQuery("jira agile scrum");

        QueryResponse response = client.query(query);
        List<Course> courses = response.getBeans(Course.class);
        for(Course course : courses) {
            printCourse(course);
        }
    }

    private static SolrQuery create(QueryType type) {
        SolrQuery query = new SolrQuery();
        switch(type) {
            case JiraAgileScrum: query.setQuery("jira agile scrum"); break;
            case JiraAgileScrumWithBoost:
                query.setQuery("jira agile scrum");
                query.set("defType", "dismax");
                query.set("qf", "comments_nl^20 id^1 name_nl^1 description_nl^0.2 url_nl^0.5 text^0.1");

                break;
        }
        return query;
    }

    private static void printCourse(Course course) {
        System.out.println(course.toString());
    }
}
