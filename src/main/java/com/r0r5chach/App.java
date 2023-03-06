package com.r0r5chach;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import com.r0r5chach.services.MultipleDocumentService;
import com.r0r5chach.services.SingleDocumentService;
import com.r0r5chach.services.generic.AuthService;
import com.r0r5chach.services.generic.SecureDBService;
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
                get("/", SingleDocumentService::authenticate); //get Document
                //POST domain.com/db/one/?token&collection=
                post("/", SingleDocumentService::authenticate); //make Document 
                //PUT domain.com/db/one/?token&collection
                put("/", SingleDocumentService::authenticate); //update Document
                //DELETE domain.com/db/one/?token&collection
                delete("/", SingleDocumentService::authenticate); //delete Document
                //OPTIONS domain.com/db/one/?token
                options("/", SingleDocumentService::authenticate); //return available options for route
            });
            //Multiple Document Queries
            path("/many", () -> {
                //GET domain.com/db/many/?token&collection
                get("/", MultipleDocumentService::authenticate); //get Documents
                //POST domain.com/db/many/?token&collection
                post("/", MultipleDocumentService::authenticate); //make Documents
                //PUT domain.com/db/many/?token&collection
                put("/", MultipleDocumentService::authenticate); //update Documents
                //DELETE domain.com/db/many/?token&collection
                delete("/", MultipleDocumentService::authenticate); //delete Documents
                //OPTIONS domain.com/db/many/?token
                options("/", MultipleDocumentService::authenticate); //return available options for route
            });
            //OPTIONS domain.com/db/?token
            options("/", SecureDBService::authenticate); //return available options for sub-routes
        });
        //Authentication
        path("/auth", () -> {
            //POST domain.com/auth/
            post("/", AuthService::authenticate); //request api token
            //OPTIONS domain.com/auth/
            options("/", AuthService::authenticate); //return available options for route
        });
    }
}