package com.r0r5chach.services;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import spark.Request;
import spark.Response;

/**
 * Class that handles communicating to the database
 * 
 * @author r0r-5chach
 */
public class DBService extends Service {
    /**
     * Static constant creating a client to access the database
     */
    protected static final MongoDatabase client = MongoClients.create().getDatabase("woodlands");

    protected static String options(Request req, Response res) {
        //TODO: create options method for database service
        return "";
    }   
}
