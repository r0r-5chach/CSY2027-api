package com.r0r5chach.binaryMindsAPI.services;

import static com.r0r5chach.binaryMindsAPI.services.AuthService.tokenAccess;
import static org.bson.Document.parse;
import static spark.Spark.halt;

import org.bson.Document;

import com.r0r5chach.binaryMindsAPI.Access;
import com.r0r5chach.binaryMindsAPI.services.db.SingleDocumentService;

import spark.Request;
import spark.Response;

public class APIService extends Service{
    protected static String collection;
    protected static Service service = new SingleDocumentService();
    
    
    public static void auth(Request req, Response res) {
        String token = req.queryMap().get("token").value();
        Document userQuery = parse(req.body());
        Document tokenQuery = new Document().append("token", token);
        userQuery = parse(service.get(req,res,collection));
        tokenQuery = parse(service.get(req, res, collection));
        if (!userQuery.getInteger("id").equals(tokenQuery.getInteger("id")) && tokenAccess(token) != Access.ADMIN) {
            halt(404, "Unauthorized");
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
