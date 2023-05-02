package com.r0r5chach.services;

import com.r0r5chach.services.generic.AuthService;
import com.r0r5chach.services.generic.Service;

import spark.Request;
import spark.Response;

public class UsersService extends Service{
    public static void auth(Request req, Response res) {
        switch(req.requestMethod()) {
            case "POST":
            case "DELETE":
                AuthService.adminAuth(req, res);
                break;
            default:
                //TODO: if user is same as queried user then allow access
                break;
        }
    }
}
