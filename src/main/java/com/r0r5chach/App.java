package com.r0r5chach;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import com.r0r5chach.services.DBService;

public class App 
{
    public static void main( String[] args )
    {
        path("/db", () -> {
            get("/", DBService::get);
            post("/", DBService::post);           
            put("/", DBService::put);
            options("/", DBService::options);
            delete("/", DBService::delete);
        });
    }
}