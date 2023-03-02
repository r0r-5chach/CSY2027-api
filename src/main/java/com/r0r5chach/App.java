package com.r0r5chach;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.options;
import static spark.Spark.delete;

import com.r0r5chach.services.Service;

public class App 
{
    public static void main( String[] args )
    {
           get("/info", Service::get); 
           post("/add", Service::post); 
           put("/edit", Service::put); 
           options("/exists", Service::options);
           delete("/delete", Service::delete);
    }
}
