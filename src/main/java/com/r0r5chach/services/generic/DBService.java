package com.r0r5chach.services.generic;

import static com.r0r5chach.services.generic.Service.noEndpoint;

import java.io.FileReader;
import java.util.Properties;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import spark.Request;
import spark.Response;

/**
 * Class that handles communicating to the database
 * 
 * @author r0r-5chach
 */
public class DBService implements Service {
    /**
     * Static constant creating a client to access the database
     */
    protected static final MongoDatabase client = MongoClients.create().getDatabase(getDB()); 

    private static String getDB() {
        Properties prop = new Properties();
        try {
            prop.load(new FileReader(DBService.class.getResource(".properties").toString()));
        }
        catch (Exception e) {
            System.out.println(e); //TODO: Handle Error
        }
        
        return prop.getProperty("database");
    }

    @Override
    public String get(Request req, Response res) {
        return noEndpoint(res);
    }

    @Override
    public String post(Request req, Response res) {
        return noEndpoint(res);
    }

    @Override
    public String put(Request req, Response res) {
        return noEndpoint(res);
    }

    @Override
    public String delete(Request req, Response res) {
        return noEndpoint(res);
    }

    @Override
    public String options(Request req, Response res) {
        // TODO: list options for endpoints
        throw new UnsupportedOperationException("Unimplemented method 'options'");
    }
}