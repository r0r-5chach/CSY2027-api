package com.r0r5chach.routes;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import com.r0r5chach.services.UsersService;
import com.r0r5chach.services.generic.Service;

public class UsersRoutes {
    private static Service service;
    public static void users() {
        service = new UsersService();
        //Route /users/
        path("/users", () -> {
            //GET /users/?token&user must be same user as edited user or admin
            get("/", (req,res) -> service.get(req,res));
            //POST /users/?token&user admin auth
            post("/", (req,res) -> service.post(req,res));
            //PUT /users/?token&user must be same user as edited user or admin
            put("/", (req,res) -> service.put(req,res));
            //DELETE /users/?token&user admin auth
            delete("/", (req,res) -> service.delete(req,res));
            //OPTIONS /users/>?token
            options("/", (req,res) -> service.options(req,res));
        });
    }
    
}
