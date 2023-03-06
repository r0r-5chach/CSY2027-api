package com.r0r5chach;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import com.r0r5chach.services.AuthService;
import com.r0r5chach.services.DBService;
import com.r0r5chach.services.MultipleDocumentService;
import com.r0r5chach.services.SingleDocumentService;
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
                get("/", SingleDocumentService::get); //get Document
                //POST domain.com/db/one/?token&collection=
                post("/", SingleDocumentService::post); //make Document 
                //PUT domain.com/db/one/?token&collection
                put("/", SingleDocumentService::put); //update Document
                //DELETE domain.com/db/one/?token&collection
                delete("/", SingleDocumentService::delete); //delete Document
                //OPTIONS domain.com/db/one/?token
                options("/", SingleDocumentService::options); //return available options for route
            });
            //Multiple Document Queries
            path("/many", () -> {
                //GET domain.com/db/many/?token&collection
                get("/", MultipleDocumentService::get); //get Documents
                //POST domain.com/db/many/?token&collection
                post("/", MultipleDocumentService::post); //make Documents
                //PUT domain.com/db/many/?token&collection
                put("/", MultipleDocumentService::put); //update Documents
                //DELETE domain.com/db/many/?token&collection
                delete("/", MultipleDocumentService::delete); //delete Documents
                //OPTIONS domain.com/db/many/?token
                options("/", MultipleDocumentService::options); //return available options for route
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