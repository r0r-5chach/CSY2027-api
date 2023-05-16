package com.r0r5chach.woodlands.services;

import com.r0r5chach.binaryMindsAPI.Access;
import com.r0r5chach.binaryMindsAPI.services.AuthService;
import com.r0r5chach.woodlands.services.db.WoodlandsSDService;

import spark.Request;
import spark.Response;

public class StaffService extends WoodlandsSDService {

    public StaffService() {
        collection = "staff";
    }
    
    public static void cdAuth(Request req, Response res) {
        switch(req.requestMethod()) {
            case "POST":
            case "DELETE":
                AuthService.accessAuth(req, res, Access.ADMIN);
                break;
            default:
                AuthService.accessAuth("tutor", req);
                break;
        }
    }
}
