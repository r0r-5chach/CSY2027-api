package com.r0r5chach;

import static spark.Spark.before;

import com.r0r5chach.binaryMindsAPI.services.AuthService;
import com.r0r5chach.woodlands.routes.Routes;
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
        //Route domain.com/auth/
        Routes.auth();

        //Route domain.com/api/
        before("/api/*", AuthService::tokenAuth);
        Routes.api();
    }
}