package com.r0r5chach.binaryMindsAPI.services;

import org.bson.Document;

import spark.Request;
import spark.Response;

public class APIService extends Service {

    public APIService() {
        service = new Service();
    }
    
    public String get(Request req, Response res) {
        return service.get(req, res);
    }

    public String post(Request req, Response res) {
        return service.post(req, res);
    }

    public String put(Request req, Response res) {
        return service.put(req, res);
    }

    public String delete(Request req, Response res) {
        return service.delete(req, res);
    }
    
    public String options(Request req, Response res) {
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
