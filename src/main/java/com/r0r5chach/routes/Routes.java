package com.r0r5chach.routes;

import static com.r0r5chach.routes.AdminRoutes.admin;
import static com.r0r5chach.routes.StaffRoutes.staff;
import static com.r0r5chach.routes.StudentRoutes.student;
import static spark.Spark.before;
import static spark.Spark.options;
import static spark.Spark.path;
import static spark.Spark.post;

import com.r0r5chach.services.generic.AuthService;

public class Routes {
    
    public static void api() {
        //Route domain.com/api/
        path ("/api", () -> {
            //Route domain.com/api/admin/
            before("/admin/*", AuthService::adminAuth);
            admin();

            before("/admin/*", AuthService::staffAuth);
            staff();

            before("/admin/*", AuthService::studentAuth);
            student();
        });
        
    }

    public static void auth() {
        AuthService service = new AuthService();
        path("/auth", () -> {
            //POST domain.com/auth/
            post("/", (req,res) -> service.post(req, res)); //request api token
            //OPTIONS domain.com/auth/
            options("/", (req,res) -> service.options(req,res)); //return available options for route
        });
    }
}
