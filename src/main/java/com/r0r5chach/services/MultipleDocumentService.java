package com.r0r5chach.services;

import static org.bson.Document.parse;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.r0r5chach.services.generic.SecureDBService;

import spark.Request;
import spark.Response;

public class MultipleDocumentService extends SecureDBService{

     /**
     * Method that handles a GET request to route /db/many/
     * @param req The request from the user
     * @param res The response to be sent to the user
     * @return A string containing the response in JSON format
     */
    protected static String get(Request req, Response res) {
        //TODO: test
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

    protected static String post(Request req, Response res) {
        //TODO: test
        List<Document> items = parse(req.body()).getList("docs", Document.class);

        try {
            client.getCollection(req.queryMap().get("collection").value()).insertMany(items);
        } 
        catch (Exception e) {
            res.status(500);
            return "{\"response\":\"Insert failed\"}";
        }

        res.status(201);
        return "{\"response\":\"Insert successful\"}";
    }

    protected static String put(Request req, Response res) {
        //TODO: test
        Document request = parse(req.body());
        Document query = parse(request.getString("query"));
        Document update = new Document().append("$set", parse(request.getString("update")));

        try {
            client.getCollection(req.queryMap().get("collection").value()).updateMany(query, update);
        } 
        catch (Exception e) {
            res.status(500);
            return "{\"response\":\"Update failed\"}";            
        }

        res.status(200);
        return "{\"response\":\"Update successful\"}";
    }

    protected static String delete(Request req, Response res) {
        //TODO: test
        Document query = parse(req.body());

        try {
            client.getCollection(req.queryMap().get("collection").value()).deleteMany(query);
        } 
        catch (Exception e) {
            res.status(500);
            return "{\"response\":\"Delete failed\"}";
        }
        
        res.status(200);
        return "{\"response\":\"Delete successful\"}";
    }

    protected static String options(Request req, Response res) {
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