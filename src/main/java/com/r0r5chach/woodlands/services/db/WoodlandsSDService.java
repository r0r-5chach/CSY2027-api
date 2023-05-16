package com.r0r5chach.woodlands.services.db;

import org.bson.Document;

import com.r0r5chach.binaryMindsAPI.services.db.SingleDocumentService;

import spark.Request;
import spark.Response;

public class WoodlandsSDService extends SingleDocumentService {

    public WoodlandsSDService(String collection) {
        this.collection = collection;
    }

    public WoodlandsSDService() {}

    public String options(Request req, Response res, String collection) {
        Document response = new Document().append("GET", "Read a Single Document in the database");
        response.append("POST", "Create a Single Document in the database");
        response.append("PUT", "Update a Single Document in the database");
        response.append("DELETE", "Delete a Single Document in the database");
        response.append("OPTIONS", "This list");
        return response.toJson();
    }
}