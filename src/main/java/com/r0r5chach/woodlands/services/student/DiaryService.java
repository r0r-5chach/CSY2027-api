package com.r0r5chach.woodlands.services.student;

import com.r0r5chach.binaryMindsAPI.Access;
import com.r0r5chach.binaryMindsAPI.services.AuthService;
import com.r0r5chach.woodlands.services.db.WoodlandsSDService;

import spark.Request;
import spark.Response;

public class DiaryService extends WoodlandsSDService {

    public DiaryService() {
        collection = "users";
    }

    public static void auth(Request req, Response res) {
        switch(req.requestMethod()) {
            case "PUT":
            case "GET":
                AuthService.accessAuth("id", req);
                break;
            default:
                AuthService.accessAuth(req, res, Access.ADMIN);
                break;
        }
    }

    //TODO: auth for request method access
}
