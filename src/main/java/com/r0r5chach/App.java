package com.r0r5chach;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import com.r0r5chach.services.AuthService;
import com.r0r5chach.services.DBService;;

public class App 
{
    public static void main( String[] args )
    {
        path("/db", () -> {
            path("/one", () -> {
                //GET domain.com/db/?token=asd&collection=asd
                get("/", DBService::getOne); //get item
                //POST domain.com/db/?token=asd&collection=asd
                post("/", DBService::postOne); //make item  
                //PUT domain.com/db/?token=asd&collection=asd
                put("/", DBService::putOne); //update item
                //DELETE domain.com/db/?token=asd&collection=asd
                delete("/", DBService::deleteOne); //delete item
            });
            
        });

        path("/auth", () -> {
            //POST domain.com/auth/?username=asd&password=asd
            post("/", AuthService::post);
        });
    }
}