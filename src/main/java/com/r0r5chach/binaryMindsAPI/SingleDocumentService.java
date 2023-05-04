package com.r0r5chach.binaryMindsAPI;

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
    public String get(Request req, Response res, String collection) {
        Document query = parse(req.body());
        checkCollection(collection, req);
        MongoCollection<Document> col = client.getCollection(collection);
            
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
     * @return A string containing the response in JSON format
     */
    public String post(Request req, Response res, String collection) {
        Document item = parse(req.body());
        checkCollection(collection, req);
        try {
            client.getCollection(collection).insertOne(item);
        } 
        catch (Exception e) {
            res.status(500);
            return "{\"response\":\"Insert failed\"}";
        }

        res.status(201);
        return "{\"response\":\"Insert successful\"}";
    }

    /**
     * Method that handles a PUT request to route /db/one/
     * 
     * @param req the request from the user
     * @param res the response to be sent to the user
     * @return A string containing the response in JSON format
     */
    public String put(Request req, Response res, String collection) {
        Document request = parse(req.body());
        Document query = parse(request.getString("query"));
        Document update = new Document().append("$set", parse(request.getString("update")));
        checkCollection(collection, req);
        try {
            client.getCollection(collection).updateOne(query, update);
        } 
        catch (Exception e) {
            res.status(500);
            return "{\"response\":\"Update failed\"}";            
        }

        res.status(200);
        return "{\"response\":\"Update successful\"}";
    }

    /**
     * Method that handles a DELETE request to route /db/one/
     * 
     * @param req The request from the user
     * @param res The response to be sent to the user
     * @return A string containing the response in JSON format
     */
    public String delete(Request req, Response res, String collection) {
        Document query = parse(req.body());
        checkCollection(collection, req);
        try {
            client.getCollection(collection).deleteOne(query);
        }
        catch (Exception e) {
            res.status(500);
            return "{\"response\":\"Delete failed\"}";
        }

        res.status(200);
        return "{\"response\":\"Delete successful\"}";
    }

    public String options(Request req, Response res) {
        //TODO: create options method for single document queries
        return "";
    }

    private void checkCollection(String collection, Request req) {
        if (collection.equals("")) {
            collection = req.queryMap().get("collection").value();
        }
    }
}