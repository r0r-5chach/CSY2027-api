package com.r0r5chach.services;

import org.bson.Document;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import spark.Request;
import spark.Response;


public class DBService {
    private static final MongoDatabase client = MongoClients.create().getDatabase("woodlands");
    
    public static Document get(Request req, Response res) {
        //TODO: Create GET method
        return new Document();
    }

    public static boolean post(Request req, Response res) {
        //TODO: Create POST method
        return false;
    }

    public static boolean put(Request req, Response res) {
        //TODO: Create PUT method
        return false;
    }

    public static boolean options(Request req, Response res) {
        //TODO: Create OPTIONS method
        return false;
    }

    public static boolean delete(Request req, Response res) {
        //TODO: Create DELETE method
        return false;
    }
}
