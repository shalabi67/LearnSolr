package com.learn.solrj.model;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;
import java.util.List;

public class Course {
    @Field
    public int id;
    @Field
    public String courseid;
    @Field
    public String coursetitle;
    @Field
    public int durationseconds;
    @Field
    public Date releasedate;
    @Field
    public String tagsdescription;
    @Field
    public List<String> tags;
    @Field
    public String description;
    @Field
    public List<String> author;
    @Field
    public List<String> authorid;
    @Field
    public int fakeviews;
    @Field
    public float fakerating;
    @Field
    public String staticsnippet;
    @Field
    public String metadata;


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseid='" + courseid + '\'' +
                ", coursetitle='" + coursetitle + '\'' +
                ", durationseconds=" + durationseconds +
                ", releasedate=" + releasedate +
                ", tagsdescription='" + tagsdescription + '\'' +
                ", tags=" + tags +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", authorid=" + authorid +
                ", fakeviews=" + fakeviews +
                ", fakerating=" + fakerating +
                ", staticsnippet='" + staticsnippet + '\'' +
                ", metadata='" + metadata + '\'' +
                '}';
    }
}
