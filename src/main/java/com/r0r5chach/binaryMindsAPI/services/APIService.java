package com.r0r5chach.binaryMindsAPI.services;

import com.r0r5chach.binaryMindsAPI.services.db.SingleDocumentService;

import spark.Request;
import spark.Response;

public class APIService extends Service{
    protected static String collection;
    protected static Service service = new SingleDocumentService();
    
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
