package com.r0r5chach.woodlands.services;

import spark.Request;
import spark.Response;

public class LessonService extends WoodlandsService {
    protected static String collection = "lessons";

    public String post(Request req, Response res) {
        return super.post(req, res);
        //TODO: when a lesson is created, make a corresponding register
    }
}
