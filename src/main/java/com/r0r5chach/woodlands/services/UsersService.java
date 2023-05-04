package com.r0r5chach.woodlands.services;

import com.r0r5chach.binaryMindsAPI.Access;
import com.r0r5chach.binaryMindsAPI.services.APIService;
import com.r0r5chach.binaryMindsAPI.services.AuthService;

import spark.Request;
import spark.Response;

public class UsersService extends WoodlandsService {
    protected static String collection = "users";

    public static void auth(Request req, Response res) {
        switch(req.requestMethod()) {
            case "POST":
            case "DELETE":
                AuthService.accessAuth(req, res, Access.ADMIN);
                break;
            default:
                APIService.auth(req, res);
                break;
        }
    }
}
