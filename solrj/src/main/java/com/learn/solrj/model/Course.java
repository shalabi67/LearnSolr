package com.learn.solrj.model;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;
import java.util.List;

public class Course {
    @Field
    public String courseid;
    @Field
    public String coursetitle;
    @Field
    public int durationseconds;
    @Field
    public Date releaseDate;
    @Field
    public String tagsdescription;
    @Field
    public List<String> tags;
    @Field
    public String description;
    @Field
    public List<String> author;
    @Field
    public List<String> authorId;
    @Field
    public int fakeviews;
    @Field
    public float fakerating;
    @Field
    public String staticsnippet;
    @Field
    public String metadata;




}
