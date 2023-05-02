package com.r0r5chach.routes;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import com.r0r5chach.services.generic.MultipleDocumentService;
import com.r0r5chach.services.generic.Service;
import com.r0r5chach.services.generic.SingleDocumentService;

public class AdminRoutes {
    private static Service service;

    public static void admin() {
        service = new Service();
        //Route /admin/
        path("/admin", () -> {
            //GET /admin/?token
            get("/", (req,res) -> service.get(req, res));
            //POST /admin/?token
            post("/", (req,res) -> service.post(req, res));
            //PUT /admin/?token
            put("/", (req,res) -> service.put(req, res));
            //DELETE /admin/?token
            delete("/", (req,res) -> service.delete(req, res));
            //OPTIONS /admin/?token
            options("/", (req,res) -> service.options(req, res)); //return available options for sub-routes
            
            //Route /admin/db/
            db();
        });
    }

    private static void db() {
        service = new Service();
        //Route /db/
        path("/db", () -> {
            //GET /db/?token
            get("/", (req,res) -> service.get(req, res));
            //POST /db/?token
            post("/", (req,res) -> service.post(req, res));
            //PUT /db/?token
            put("/", (req,res) -> service.put(req, res));
            //DELETE /db/?token
            delete("/", (req,res) -> service.delete(req, res));
            //OPTIONS /db/?token
            options("/", (req,res) -> service.options(req, res)); //return available options for sub-routes
            
            //Route /db/one/
            dbOne();
            //Route /db/many/
            dbMany();
        });
    }

    private static void dbOne() {
        //Route /one/
        path("/one", () -> {
            service = new SingleDocumentService();
            //GET /one/?token&collection
            get("/", (req,res) -> service.get(req, res)); //get Document
            //POST /one/?token&collection
            post("/", (req,res) -> service.post(req, res)); //make Document 
            //PUT /one/?token&collection
            put("/", (req,res) -> service.put(req, res)); //update Document
            //DELETE /one/?token&collection
            delete("/", (req,res) -> service.delete(req, res)); //delete Document
            //OPTIONS /one/?token
            options("/", (req,res) -> service.options(req, res)); //return available options for route
        });
    }

    private static void dbMany() {
        //Route /many/
        path("/many", () -> {
            service = new MultipleDocumentService();
            //GET /many/?token&collection
            get("/", (req,res) -> service.get(req,res)); //get Documents
            //POST /many/?token&collection
            post("/", (req,res) -> service.post(req,res)); //make Documents
            //PUT /many/?token&collection
            put("/", (req,res) -> service.put(req,res)); //update Documents
            //DELETE /many/?token&collection
            delete("/", (req,res) -> service.delete(req,res)); //delete Documents
            //OPTIONS domain.com/db/many/?token
            options("/", (req,res) -> service.options(req,res)); //return available options for route
        });
    }
    
}
