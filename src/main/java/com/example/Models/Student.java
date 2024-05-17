package com.example.Models;

import org.apache.solr.client.solrj.beans.Field;

public class Student {
    String id;
    String subject;
    int marks;


    public String getId() {
        return id;
    }
    @Field("id")
    public void setId(String id) {
        this.id = id;
    }
    public String getSubject() {
        return subject;
    }
    @Field("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public int getMarks() {
        return marks;
    }
    @Field("marks")
    public void setMarks(int marks) {
        this.marks = marks;
    }

    
}
