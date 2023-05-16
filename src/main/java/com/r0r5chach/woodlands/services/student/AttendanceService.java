package com.r0r5chach.woodlands.services.student;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.r0r5chach.binaryMindsAPI.Access;
import com.r0r5chach.binaryMindsAPI.services.AuthService;
import com.r0r5chach.woodlands.services.db.WoodlandsSDService;

import spark.Request;
import spark.Response;

public class AttendanceService extends WoodlandsSDService {

    public AttendanceService() {
        collection = "registers";
    }

    public static void auth(Request req, Response res) {
        switch(req.requestMethod()) {
            case "POST":
            case "DELETE":
                AuthService.accessAuth(req, res, Access.ADMIN);
                break;
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
                        AuthService.accessAuth("_id",req);
                        break;
                    case ADMIN:
                        break;
                }
                break;
        }
    }
    

    public String get(Request req, Response res) {
        Document query = Document.parse(req.body());
        Document result = super.get(collection, new ObjectId(query.getString("lesson")));
        return result.toJson();
        //FIXME: Currently only outputs register, get method to look through attendance and return the attendance for that lesson instead of the whole document
    }

    public String put(Request req, Response res) {
        //TODO: get register with student in it
        // remove from current attendance list
        // put into attendance list specified
        return "";
    }
}
