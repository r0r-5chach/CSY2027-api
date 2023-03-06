package com.r0r5chach.services;

import static org.bson.Document.parse;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import spark.Request;
import spark.Response;

public class MultipleDocumentService extends DBService{
 /**
     * Method that handles a GET request to route /db/many/
     * @param req The request from the user
     * @param res The response to be sent to the user
     * @return A string containing the response in JSON format
     */
    public static String get(Request req, Response res) {
        res.type("application/json");
        Document query = parse(req.body());
        MongoCollection<Document> col = client.getCollection(req.queryMap().get("collection").value());
        
        if (col.countDocuments(query) > 0) {
            res.status(200);
            return toJson(col.find(query));  
        } 
        else {
            res.status(500);
            return "{\"response\":\"No Documents found\"}";
        }   
    }

    public static int post(Request req, Response res) {
        //TODO: create post method for multiple document queries
        return 0;
    }

    public static int put(Request req, Response res) {
        //TODO: create put method for multiple document queries
        return 0;
    }

    public static int delete(Request req, Response res) {
        //TODO: create delete method for multiple document queries
        return 0;
    }

    public static String options(Request req, Response res) {
        //TODO: create options method for multiple document queries
        return "";
    }

    private static String toJson(FindIterable<Document> docs) {
        StringBuilder output = new StringBuilder("{\"results\" : [");
        //TODO: test
        for (Document doc : docs) {
            output.append("\"" + doc.toJson() + "\",");
        }
        output.deleteCharAt(output.length());
        output.append("]}");
        return output.toString();
    }
}
