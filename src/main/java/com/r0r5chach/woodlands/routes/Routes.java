package com.r0r5chach.woodlands.routes;

import static com.r0r5chach.woodlands.routes.AdminRoutes.admin;
import static com.r0r5chach.woodlands.routes.StaffRoutes.staff;
import static com.r0r5chach.woodlands.routes.StudentRoutes.student;
import static com.r0r5chach.woodlands.routes.UsersRoutes.users;
import static spark.Spark.before;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import com.r0r5chach.binaryMindsAPI.Access;
import com.r0r5chach.binaryMindsAPI.services.APIService;
import com.r0r5chach.binaryMindsAPI.services.AuthService;
import com.r0r5chach.binaryMindsAPI.services.Service;
import com.r0r5chach.woodlands.services.UserService;

public class Routes {
    private static Service service;
    
    public static void api() {
        service = new APIService();
        //Route /api/
        path ("/api", () -> {
            //Route /api/admin/
            before("/admin/*", (req,res) -> AuthService.accessAuth(req, res, Access.ADMIN));
            admin();

            //Route /api/staff/
            before("/staff/*", (req,res) -> AuthService.accessAuth(req, res, Access.STAFF));
            staff();

            
            //Route /api/users/
            before("/users/*", UserService::auth);
            users();

            //Route /api/student/
            student();

            restful(service);
        });
        
    }

    public static void auth() {
        service = new AuthService();
        //Route /auth/
        path("/auth", () -> {
            //POST /auth/
            //OPTIONS /auth/
            restful(service);
        });
    }

    public static void restful(Service service) {
        get("/", (req,res) -> service.get(req, res, ""));
        post("/", (req,res) -> service.post(req, res, ""));
        put("/", (req,res) -> service.put(req, res, ""));
        delete("/", (req,res) -> service.delete(req, res, ""));
        options("/", (req,res) -> service.options(req, res, "")); //return available options for sub-routes
    }
}
