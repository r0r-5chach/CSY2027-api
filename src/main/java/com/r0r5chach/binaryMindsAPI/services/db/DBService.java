package com.r0r5chach.binaryMindsAPI.services.db;

import java.io.FileReader;
import java.util.Properties;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.r0r5chach.binaryMindsAPI.services.Service;

/**
 * Class that handles communicating to the database
 * 
 * @author r0r-5chach
 */
public class DBService extends Service {
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
}