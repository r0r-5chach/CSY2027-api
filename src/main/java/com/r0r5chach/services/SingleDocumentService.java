package com.r0r5chach.services;

import static org.bson.Document.parse;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import spark.Request;
import spark.Response;

public class SingleDocumentService extends DBService {
        /**
     * Method that handles a GET request on route /db/one/
     * 
     * @param req the request from the user
     * @param res the response to be sent to the user
     * @return A string containing the response in JSON format
     */
    public static String get(Request req, Response res) {
        res.type("application/json");
        Document query = parse(req.body());
        MongoCollection<Document> col = client.getCollection(req.queryMap().get("collection").value());
        
        if (col.countDocuments(query) > 0) {
            res.status(200);
            return col.find(query).first().toJson();
        } 
        else {
            res.status(500);
            return "{\"response\":\"No Documents found\"}";
        }
    }

    /**
     * Method that handles a POST request to route /db/one/
     * 
     * @param req the request from the user
     * @param res the response to be sent to the user
     * @return The appropriate response code (201 Created; 500 Internal error)
     */
    public static int post(Request req, Response res) {
        Document item = parse(req.body());

        try {
            client.getCollection(req.queryMap().get("collection").value()).insertOne(item);
        } 
        catch (Exception e) {
            res.status(500);
            return 500;
        }

        res.status(201);
        return 201;
    }

    /**
     * Method that handles a PUT request to route /db/one/
     * 
     * @param req the request from the user
     * @param res the response to be sent to the user
     * @return The appropriate response code (200 OK; 500 Internal error)
     */
    public static int put(Request req, Response res) {
        Document request = parse(req.body());
        Document query = parse(request.getString("query"));
        Document update = new Document().append("$set", parse(request.getString("update")));

        try {
            client.getCollection(req.queryMap().get("collection").value()).updateOne(query, update);
        } 
        catch (Exception e) {
            res.status(500);
            return 500;
        }

        res.status(200);
        return 200;
    }

    /**
     * Method that handles a DELETE request to route /db/one/
     * 
     * @param req The request from the user
     * @param res The response to be sent to the user
     * @return The appropriate response code (200 OK; 404 Not Found)
     */
    public static int delete(Request req, Response res) {
        Document query = parse(req.body());

        if (client.getCollection(req.queryMap().get("collection").value()).findOneAndDelete(query) != null) {
            res.status(200);
            return 200;
        } 
        else {
            res.status(404);
            return 404;
        }
    }

    public static String options(Request req, Response res) {
        //TODO: create options method for single document queries
        return "";
    }
}