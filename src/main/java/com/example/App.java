package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import com.example.Models.Student;

public class App 
{
    String urlString = "http://localhost:8983/solr/" + corename;
    Http2SolrClient solr  = new Http2SolrClient.Builder(urlString).build();
 
    final static String corename = "";

    protected String insertDoc() throws IOException, SolrServerException {
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "10");
        document.addField("subject", "CS");
        document.addField("marks", 100);

        Student s1 = new Student();
        s1.setId("123");
        s1.setMarks(100);
        s1.setSubject("geo");

        solr.addBean(s1);
        solr.add(document);
        solr.commit();

        return "Added successfully";
    }

    protected void sendFile() throws Exception {
        Path fpath = Paths.get("./resources/hello.txt");
        byte[] data = Files.readAllBytes(fpath);

        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", UUID.randomUUID().toString());
        document.addField("bookData", data);
        solr.add(document);
        solr.commit();
    }

    public static void main( String[] args ) throws Exception
    {
        /* App app = new App();
        Http2SolrClient solr = app.solr;
        

        SolrQuery query = new SolrQuery();
        query.setQuery("subject:geo");

        QueryResponse qres = solr.query(query);
        SolrDocumentList docs = qres.getResults();

        for (SolrDocument doc : docs) {
            System.out.println(doc);
        }

        solr.deleteById("123");
        solr.deleteByQuery("subject: geo"); */
        App app = new App();

        app.sendFile();
    }
}
