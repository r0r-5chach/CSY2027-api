package com.r0r5chach;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import com.r0r5chach.services.AuthService;
import com.r0r5chach.services.DBService;;

/**
 * Entrypoint class for the API. This sets up the paths and their references to methods in the code
 * 
 * @author r0r-5chach
 */
public class App 
{
    /**
     * Main method for the API
     * @param args arguments to be passed to the program
     */
    public static void main( String[] args )
    {
        //Route domain.com/db/
        path("/db", () -> {
            //Route domain.com/db/one/
            path("/one", () -> {
                //GET domain.com/db/?token=asd&collection=asd
                get("/", DBService::getOne); //Get Document
                
                //POST domain.com/db/?token=asd&collection=asd
                post("/", DBService::postOne); //Make Document 
                
                //PUT domain.com/db/?token=asd&collection=asd
                put("/", DBService::putOne); //Update Document
                
                //DELETE domain.com/db/?token=asd&collection=asd
                delete("/", DBService::deleteOne); //Delete Document
            });
            
        });
        //Route domain.com/auth/
        path("/auth", () -> {
            //POST domain.com/auth/?username=asd&password=asd
            post("/", AuthService::post); //Request API token
        });
    }
}