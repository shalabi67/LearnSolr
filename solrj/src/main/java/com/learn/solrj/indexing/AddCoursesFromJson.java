package com.learn.solrj.indexing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.solrj.connection.Client;
import com.learn.solrj.model.Course;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

@SuppressWarnings("Since15")
public class AddCoursesFromJson {
    public static void main(String[] args) throws IOException, SolrServerException {
        System.out.println("adding documents to courses from json file.");

        SolrClient client = Client.connectToLocalCourses();


        String coursesJson = readFile("courses.json", StandardCharsets.UTF_8);
        Course[] courses = getCoursesFromJson(coursesJson);
        for(int i=0;i<courses.length;i++) {
            courses[i].id = i +1;
        }

        UpdateResponse response = client.addBeans(Arrays.asList(courses));

        client.commit();
    }

    private static Course[] getCoursesFromJson(String coursesJson) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Course[] courses = mapper.readValue(coursesJson, Course[].class);

        return courses;
    }

    private static String readFile(String fileName, Charset encoding)
            throws IOException
    {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File file = new File(classloader.getResource(fileName).getFile());

        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
    }
}
