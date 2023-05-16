package com.r0r5chach.woodlands.services.db;

import org.bson.Document;

import com.r0r5chach.binaryMindsAPI.services.APIService;

import spark.Request;
import spark.Response;

public class WoodlandsDBService extends APIService {

    public String options(Request req, Response res) {
        Document response = new Document().append("GET", "No Endpoint");
        response.append("POST", "No Endpoint");
        response.append("PUT", "No Endpoint");
        response.append("DELETE", "No Endpoint");
        response.append("OPTIONS", "This list");
        response.append("/one", "Endpoints to manipulate Single Documents in the database");
        response.append("/many", "Endpoints to manipulate Multiple Documents in the database");
        return response.toJson();
    }
}
