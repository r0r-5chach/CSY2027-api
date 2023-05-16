package com.r0r5chach.binaryMindsAPI.services;

import org.bson.Document;

import spark.Request;
import spark.Response;

public class Service {
    protected String collection = "";
    protected Service service;
    
    public String get(Request req, Response res) {
        return noEndpoint(res);
    }

    public Document get(String collection, int id) {
        return null;
    }

    public String post(Request req, Response res) {
        return noEndpoint(res);
    }
    public String put(Request req, Response res) {
        return noEndpoint(res);
    }
    public String delete(Request req, Response res) {
        return noEndpoint(res);
    }
    public String options(Request req, Response res) {
        return noEndpoint(res);
    }
    public static String noEndpoint(Response res) {
        res.status(404);
        return "{\"response\":\"No Endpoint\"}";
    }
}