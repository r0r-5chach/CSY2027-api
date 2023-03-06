package com.r0r5chach.services.generic;

import static com.r0r5chach.services.generic.AuthService.tokenExists;

import spark.Request;
import spark.Response;

public class SecureDBService extends DBService {
    public static String authenticate(Request req, Response res) {
        res.type("application/json");
        if (tokenExists(req.queryMap().get("token").value())) {
            return switch (req.requestMethod()) {
                case "GET" -> get(req, res);
                case "POST" -> post(req, res);
                case "PUT" -> put(req, res);
                case "DELETE" -> delete(req, res);
                case "OPTIONS" -> options(req, res);
                default -> noEndpoint(res);
            };
        }
        else {
            res.status(401);
            return "{\"response\":\"Unauthorized\"}";
        }
    }

    protected static String options(Request req, Response res) {
        //TODO: create options method for database service
        return "";
    }
}