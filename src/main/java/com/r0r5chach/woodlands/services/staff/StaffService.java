package com.r0r5chach.woodlands.services.staff;

import com.r0r5chach.binaryMindsAPI.Access;
import com.r0r5chach.binaryMindsAPI.services.AuthService;
import com.r0r5chach.woodlands.services.WoodlandsService;

import spark.Request;
import spark.Response;

public class StaffService extends WoodlandsService {
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
}
