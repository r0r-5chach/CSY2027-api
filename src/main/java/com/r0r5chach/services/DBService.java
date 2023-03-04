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
 * 
 * @author r0r-5chach
 */
public class DBService {
    /**
     * Static constant creating a client to access the database
     */
    private static final MongoDatabase client = MongoClients.create().getDatabase("woodlands");

    public static String options(Request req, Response res) {
        //TODO: create options method for database service
        return "";
    }

    /**
     * Method that handles a GET request on route /db/one/
     * 
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
     * 
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
     * 
     * @param req the request from the user
     * @param res the response to be sent to the user
     * @return The appropriate response code (200 OK; 500 Internal error)
     */
    public static int putOne(Request req, Response res) {
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

    public static String optionsOne(Request req, Response res) {
        //TODO: create options method for single document queries
        return "";
    }

    /**
     * Method that handles a GET request to route /db/many/
     * @param req The request from the user
     * @param res The response to be sent to the user
     * @return A string containing the response in JSON format
     */
    public static String getMany(Request req, Response res) {
        res.type("application/json");
        Document query = parse(req.body());
        MongoCollection<Document> col = client.getCollection(req.queryMap().get("collection").value());
        
        if (col.countDocuments(query) > 0) {
            res.status(200);
            StringBuilder output = new StringBuilder("{\"results\" : [");
            //TODO: test
            for (Document result : col.find(query)) {
                output.append("\"" + result.toJson() + "\",");
            }
            output.deleteCharAt(output.length());
            output.append("]}");
            return output.toString();
        } 
        else {
            res.status(500);
            return "{\"response\":\"No Documents found\"}";
        }   
    }

    public static int postMany(Request req, Response res) {
        //TODO: create post method for multiple document queries
        return 0;
    }

    public static int putMany(Request req, Response res) {
        //TODO: create put method for multiple document queries
        return 0;
    }

    public static int deleteMany(Request req, Response res) {
        //TODO: create delete method for multiple document queries
        return 0;
    }

    public static int optionsMany(Request req, Response res) {
        //TODO: create options method for multiple document queries
        return 0;
    }
}
