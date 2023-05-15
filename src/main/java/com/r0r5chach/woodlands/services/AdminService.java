package com.r0r5chach.woodlands.services;

import org.bson.Document;

import spark.Request;
import spark.Response;

public class AdminService extends WoodlandsService {
    public String options(Request req, Response res, String collection) {
        Document response = new Document().append("GET", "No Endpoint");
        response.append("POST", "No Endpoint");
        response.append("PUT", "No Endpoint");
        response.append("DELETE", "No Endpoint");
        response.append("OPTIONS", "This list");
        response.append("/db", "Endpoints to directly interface with the database");
        response.append("/lessons", "CRUD Endpoints for Lessons");
        response.append("/rooms", "CRUD Endpoints for Rooms");
        return response.toJson();
    }
}
