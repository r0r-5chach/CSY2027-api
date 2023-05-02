package com.r0r5chach.services.generic;

import spark.Request;
import spark.Response;

public interface Service {
    abstract String get(Request req, Response res);
    abstract String post(Request req, Response res);
    abstract String put(Request req, Response res);
    abstract String delete(Request req, Response res);
    abstract String options(Request req, Response res);
    public static String noEndpoint(Response res) {
        res.status(404);
        return "{\"response\":\"No Endpoint\"}";
    }
}