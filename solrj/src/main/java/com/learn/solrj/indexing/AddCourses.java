package com.learn.solrj.indexing;

import com.learn.solrj.connection.Client;
import com.learn.solrj.model.Course;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;

import java.io.IOException;

/*
see Creating schem core
in the notes to create courses core.

before you start delete all documents by running:
curl http://localhost:8983/solr/courses/update?commit=true -H "Content-Type: text/xml" --data-binary "<delete><query>*:*</query></delete>"

 */
public class AddCourses {
    public static void main(String[] args) throws IOException, SolrServerException {
        System.out.println("adding documents to courses.");

        SolrClient client = Client.connectToLocal();

        Course course = createCourse();

        UpdateResponse response = client.addBean("courses", course);

        client.commit("courses");
    }

    private static Course createCourse() {
        Course course = new Course();
        course.courseid= "shalabi-course";
        course.coursetitle = "Intorduction to solr";

        return course;
    }
}
