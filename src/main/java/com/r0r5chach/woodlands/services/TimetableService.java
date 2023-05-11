package com.r0r5chach.woodlands.services;

import com.r0r5chach.binaryMindsAPI.Access;
import com.r0r5chach.binaryMindsAPI.services.AuthService;

import spark.Request;
import spark.Response;

public class TimetableService extends WoodlandsService {
    protected static String collection = "lessons";
    //TODO: auth for request method access
    public static void auth(Request req, Response res) {
        switch(req.requestMethod()) {
            case "GET":
                AuthService.accessAuth("id", req);
                break;
            default:
                AuthService.accessAuth(req, res, Access.ADMIN);
                break;
        }
    }
    //TODO: get collates a timetable for the student or teacher
}
