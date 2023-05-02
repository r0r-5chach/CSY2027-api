package com.r0r5chach.routes;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import com.r0r5chach.services.MultipleDocumentService;
import com.r0r5chach.services.SingleDocumentService;
import com.r0r5chach.services.generic.DBService;
import com.r0r5chach.services.generic.Service;

public class AdminRoutes {
    private static Service service;

    public static void admin() {
        path("/admin", () -> {
            get("/", (req,res) -> service.get(req, res));
            post("/", (req,res) -> service.post(req, res));
            put("/", (req,res) -> service.put(req, res));
            delete("/", (req,res) -> service.delete(req, res));
            //OPTIONS domain.com/db/?token
            options("/", (req,res) -> service.options(req, res)); //return available options for sub-routes
            
            //Route domain.com/
            db();
        });
    }

    private static void db() {
        service = new DBService();
        path("/db", () -> {
            get("/", (req,res) -> service.get(req, res));
            post("/", (req,res) -> service.post(req, res));
            put("/", (req,res) -> service.put(req, res));
            delete("/", (req,res) -> service.delete(req, res));
            //OPTIONS domain.com/db/?token
            options("/", (req,res) -> service.options(req, res)); //return available options for sub-routes
            
            //Single Document Queries
            dbOne();
            //Multiple Document Queries
            dbMany();
        });
    }

    private static void dbOne() {
        path("/one", () -> {
            service = new SingleDocumentService();
            //GET domain.com/db/one/?token&collection
            get("/", (req,res) -> service.get(req, res)); //get Document
            //POST domain.com/db/one/?token&collection=
            post("/", (req,res) -> service.post(req, res)); //make Document 
            //PUT domain.com/db/one/?token&collection
            put("/", (req,res) -> service.put(req, res)); //update Document
            //DELETE domain.com/db/one/?token&collection
            delete("/", (req,res) -> service.delete(req, res)); //delete Document
            //OPTIONS domain.com/db/one/?token
            options("/", (req,res) -> service.options(req, res)); //return available options for route
        });
    }

    private static void dbMany() {
        path("/many", () -> {
            service = new MultipleDocumentService();
            //GET domain.com/db/many/?token&collection
            get("/", (req,res) -> service.get(req,res)); //get Documents
            //POST domain.com/db/many/?token&collection
            post("/", (req,res) -> service.post(req,res)); //make Documents
            //PUT domain.com/db/many/?token&collection
            put("/", (req,res) -> service.put(req,res)); //update Documents
            //DELETE domain.com/db/many/?token&collection
            delete("/", (req,res) -> service.delete(req,res)); //delete Documents
            //OPTIONS domain.com/db/many/?token
            options("/", (req,res) -> service.options(req,res)); //return available options for route
        });
    }
    
}
