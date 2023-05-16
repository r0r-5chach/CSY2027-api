package com.r0r5chach.woodlands.services.student;

import com.r0r5chach.binaryMindsAPI.Access;
import com.r0r5chach.binaryMindsAPI.services.AuthService;
import com.r0r5chach.woodlands.services.db.WoodlandsSDService;

import spark.Request;
import spark.Response;

public class AssignmentService extends WoodlandsSDService {

    public AssignmentService() {
        collection = "assignments";
    }

    public static void auth(Request req, Response res) {
        switch(req.requestMethod()) {
            case "POST":
            case "DELETE":
            case "PUT":
                AuthService.accessAuth("tutor", req);
                AuthService.accessAuth(req, res, Access.STAFF);
                break;
            default:
                switch(AuthService.tokenAccess(req.queryMap().get("token").value())) {
                    case STAFF:
                        AuthService.accessAuth("tutor", req);
                        break;
                    case STUDENT:
                        AuthService.accessAuth("id",req);
                        break;
                    case ADMIN:
                        break;
                }
                break;
        }
    }
}
