package com.r0r5chach;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import com.r0r5chach.services.AuthService;
import com.r0r5chach.services.DBService;;
/**
 * Class that handles the entry point for the api and setup routes
 * 
 * @author r0r-5chach
 */
public class App 
{
    /**
     * Main method for the api
     * @param args The arguments passed to the program
     */
    public static void main( String[] args )
    {
        path("/db", () -> {
            //Single Document Queries
            path("/one", () -> {
                //GET domain.com/db/one/?token&collection
                get("/", DBService::getOne); //get Document
                //POST domain.com/db/one/?token&collection=
                post("/", DBService::postOne); //make Document 
                //PUT domain.com/db/one/?token&collection
                put("/", DBService::putOne); //update Document
                //DELETE domain.com/db/one/?token&collection
                delete("/", DBService::deleteOne); //delete Document
                //OPTIONS domain.com/db/one/?token
                options("/", DBService::optionsOne); //return available options for route
            });
            //Multiple Document Queries
            path("/many", () -> {
                //GET domain.com/db/many/?token&collection
                get("/", DBService::getMany); //get Documents
                //POST domain.com/db/many/?token&collection
                post("/", DBService::postMany); //make Documents
                //PUT domain.com/db/many/?token&collection
                put("/", DBService::putMany); //update Documents
                //DELETE domain.com/db/many/?token&collection
                delete("/", DBService::deleteMany); //delete Documents
                //OPTIONS domain.com/db/many/?token
                options("/", DBService::optionsMany); //return available options for route
            });
            //OPTIONS domain.com/db/?token
            options("/", DBService::options); //return available options for sub-routes
        });
        //Authentication
        path("/auth", () -> {
            //POST domain.com/auth/?username=asd&password=asd
            post("/", AuthService::post); //request api token
            //OPTIONS domain.com/auth/
            options("/", AuthService::options); //return available options for route
        });
    }
}