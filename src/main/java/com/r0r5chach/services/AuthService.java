package com.r0r5chach.services;

import spark.Request;
import spark.Response;

public class AuthService {
    public static String post(Request req, Response res) {
        //TODO: if username and password are correct return api token and store in db;Otherwise return 401 unauthorized
        return "";
    }

    public static boolean authenticate() {
        //TODO: if token is valid return true;Otherwise delete token and return 401 unauthorized
        return false;
    }
}
