package com.r0r5chach.services.generic;

import static org.bson.Document.parse;
import static spark.Spark.halt;

import org.bson.Document;

import spark.Request;
import spark.Response;

public class APIService {
    protected static String collection;
    protected static Service service = new SingleDocumentService();
    public static void auth(Request req, Response res) {
        Document userQuery = parse(req.body());
        Document tokenQuery = new Document().append("token", req.queryMap().get("token").value());
        switch(req.requestMethod()) {
            case "POST":
            case "DELETE":
                AuthService.adminAuth(req, res);
                break;
            default:
                userQuery = parse(service.get(req,res,collection));
                tokenQuery = parse(service.get(req, res, collection));
                if (!userQuery.getInteger("id").equals(tokenQuery.getInteger("id"))) {
                    halt(404, "Unauthorized");
                }
                break;
        }
    }

    public String get(Request req, Response res) {
        return service.get(req, res, collection);
    }

    public String post(Request req, Response res) {
        return service.post(req, res, collection);
    }

    public String put(Request req, Response res) {
        return service.put(req, res, collection);
    }

    public String delete(Request req, Response res) {
        return service.delete(req, res, collection);
    }
    
}
