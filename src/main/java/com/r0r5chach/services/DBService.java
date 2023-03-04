package com.r0r5chach.services;

import static org.bson.Document.parse;

import org.bson.Document;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import spark.Request;
import spark.Response;

/**
 * Class that handles communicating to the database
 * @author r0r-5chach
 */
public class DBService {
    /**
     * Static constant creating a client to access the database
     */
    private static final MongoDatabase client = MongoClients.create().getDatabase("woodlands");
    /**
     * Method that handles a GET request on route /db/one/
     * @param req the request from the user
     * @param res the response to be sent to the user
     * @return A string containing the response in JSON format
     */
    public static String getOne(Request req, Response res) {
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
     * @param req the request from the user
     * @param res the response to be sent to the user
     * @return The appropriate response code (201 Created; 500 Internal error)
     */
    public static int postOne(Request req, Response res) {
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
     * @param req the request from the user
     * @param res the response to be sent to the user
     * @return The appropriate response code (200 OK; 500 Internal error)
     */
    public static int putOne(Request req, Response res) {
        Document request = parse(req.body());
        Document query = parse(request.getString("query"));
        Document update = parse(request.getString("update"));
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
     * @param req The request from the user
     * @param res The response to be sent to the user
     * @return The appropriate response code (200 OK; 404 Not Found)
     */
    public static int deleteOne(Request req, Response res) {
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
}
