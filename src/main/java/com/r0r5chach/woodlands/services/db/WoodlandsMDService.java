package com.r0r5chach.woodlands.services.db;

import org.bson.Document;

import com.r0r5chach.binaryMindsAPI.services.db.MultipleDocumentService;

import spark.Request;
import spark.Response;

public class WoodlandsMDService extends MultipleDocumentService {

    public String options(Request req, Response res, String collection) {
        Document response = new Document().append("GET", "Read Multiple Documents in the database");
        response.append("POST", "Create Multiple Documents in the database");
        response.append("PUT", "Update Multiple Documents in the database");
        response.append("DELETE", "Delete Multiple Documents in the database");
        response.append("OPTIONS", "This list");
        return response.toJson();
    }

}