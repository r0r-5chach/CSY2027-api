package com.r0r5chach.woodlands.services;

import com.r0r5chach.binaryMindsAPI.Access;
import com.r0r5chach.binaryMindsAPI.services.APIService;
import com.r0r5chach.binaryMindsAPI.services.AuthService;

import spark.Request;
import spark.Response;

public class StaffService extends APIService{
    protected static String collection = "staff";

    //TODO: Advanced endpoints
    //timetable service
    //diary service

    public static void cdAuth(Request req, Response res) {
        switch(req.requestMethod()) {
            case "POST":
            case "DELETE":
                AuthService.accessAuth(req, res, Access.ADMIN);
                break;
        }
    }

    public static class CourseService extends APIService {
        protected static String collection = "courses";

    }

    public static class ModuleService extends APIService {
        protected static String collection = "modules";
    }
}
