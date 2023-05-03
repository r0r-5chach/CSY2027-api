package com.r0r5chach.services;

import static org.bson.Document.parse;
import static spark.Spark.halt;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.r0r5chach.services.generic.AuthService;
import com.r0r5chach.services.generic.DBService;

import spark.Request;
import spark.Response;

public class UsersService extends DBService{
    private static final MongoCollection<Document> col = client.getCollection("users");
    public static void auth(Request req, Response res) {
        Document userQuery = parse(req.body());
        Document tokenQuery = new Document().append("token", req.queryMap().get("token").value());
        switch(req.requestMethod()) {
            case "POST":
            case "DELETE":
                AuthService.adminAuth(req, res);
                break;
            default:
                if (!col.find(userQuery).first().getInteger("id").equals(col.find(tokenQuery).first().getInteger("id"))) {
                    halt(404, "Unauthorized");
                }
                break;
        }
    }
}
