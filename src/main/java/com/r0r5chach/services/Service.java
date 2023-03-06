package com.r0r5chach.services;

import spark.Request;
import spark.Response;

public class Service {
    public static String authenticate(Request req, Response res) {
        res.type("application/json");
        return switch (req.requestMethod()) {
            case "GET" -> get(req, res);
            case "POST" -> post(req, res);
            case "PUT" -> put(req, res);
            case "DELETE" -> delete(req, res);
            case "OPTIONS" -> options(req, res);
            default -> noEndpoint(res);
        };
    }

    protected static String get(Request req, Response res) {
        return noEndpoint(res);
    }

    protected static String post(Request req, Response res) {
        return noEndpoint(res);
    }

    protected static String put(Request req, Response res) {
        return noEndpoint(res);
    }

    protected static String delete(Request req, Response res) {
        return noEndpoint(res);
    }

    protected static String options(Request req, Response res) {
        return noEndpoint(res);
    }

    protected static String noEndpoint(Response res) {
        res.status(404);
        return "{\"response\":\"No Endpoint\"}";
    }
}
