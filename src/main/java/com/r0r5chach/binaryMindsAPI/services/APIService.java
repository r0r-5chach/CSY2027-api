package com.r0r5chach.binaryMindsAPI.services;

import org.bson.Document;

import spark.Request;
import spark.Response;

public class APIService extends Service{
    protected static String collection;
    protected static Service service = new Service();
    
    public String get(Request req, Response res, String collection) {
        return service.get(req, res, collection);
    }

    public String post(Request req, Response res, String collection) {
        return service.post(req, res, collection);
    }

    public String put(Request req, Response res, String collection) {
        return service.put(req, res, collection);
    }

    public String delete(Request req, Response res, String collection) {
        return service.delete(req, res, collection);
    }
    
    public String options(Request req, Response res, String collection) {
        Document response = new Document().append("GET", "No Endpoint");
        response.append("POST", "No Endpoint");
        response.append("PUT", "No Endpoint");
        response.append("DELETE", "No Endpoint");
        response.append("OPTIONS", "This list");
        response.append("/admin", "Endpoints relevant to admin accounts, only accessible by admin access");
        response.append("/staff", "Endpoints relevant to staff accounts, only accessible by staff access or above");
        response.append("/student", "Endpoints relevant to student accounts");
        response.append("/users", "Endpoints relevant to all users");
        return response.toJson();
    }
}
