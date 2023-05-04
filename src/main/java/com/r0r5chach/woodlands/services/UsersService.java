package com.r0r5chach.woodlands.services;

import static com.r0r5chach.binaryMindsAPI.AuthService.tokenAccess;
import static org.bson.Document.parse;
import static spark.Spark.halt;

import org.bson.Document;

import com.r0r5chach.binaryMindsAPI.Access;
import com.r0r5chach.binaryMindsAPI.AuthService;

import spark.Request;
import spark.Response;

public class UsersService extends WoodlandsService {
    protected static String collection = "users";

    public static void auth(Request req, Response res) {
        String token = req.queryMap().get("token").value();
        Document userQuery = parse(req.body());
        Document tokenQuery = new Document().append("token", token);
        switch(req.requestMethod()) {
            case "POST":
            case "DELETE":
                AuthService.adminAuth(req, res);
                break;
            default:
                userQuery = parse(service.get(req,res,collection));
                tokenQuery = parse(service.get(req, res, collection));
                if (!userQuery.getInteger("id").equals(tokenQuery.getInteger("id")) && tokenAccess(token) != Access.ADMIN) {
                    halt(404, "Unauthorized");
                }
                break;
        }
    }
}
