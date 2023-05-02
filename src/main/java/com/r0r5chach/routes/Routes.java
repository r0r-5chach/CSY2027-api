package com.r0r5chach.routes;

import static com.r0r5chach.routes.AdminRoutes.admin;
import static com.r0r5chach.routes.StaffRoutes.staff;
import static com.r0r5chach.routes.StudentRoutes.student;
import static com.r0r5chach.routes.UsersRoutes.users;
import static spark.Spark.before;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import com.r0r5chach.services.UsersService;
import com.r0r5chach.services.generic.AuthService;
import com.r0r5chach.services.generic.Service;

public class Routes {
    
    public static void api() {
        //Route /api/
        path ("/api", () -> {
            //Route /api/admin/
            before("/admin/*", AuthService::adminAuth);
            admin();

            //Route /api/staff/
            before("/staff/*", AuthService::staffAuth);
            staff();

            //Route /api/student/
            before("/student/*", AuthService::studentAuth);
            student();

            //Route /api/users/
            before("/users/*", UsersService::auth);
            users();
        });
        
    }

    public static void auth() {
        AuthService service = new AuthService();
        //Route /auth/
        path("/auth", () -> {
            //POST /auth/
            //OPTIONS /auth/
            restful(service);
        });
    }

    public static void restful(Service service) {
        get("/", (req,res) -> service.get(req, res));
        post("/", (req,res) -> service.post(req, res));
        put("/", (req,res) -> service.put(req, res));
        delete("/", (req,res) -> service.delete(req, res));
        options("/", (req,res) -> service.options(req, res)); //return available options for sub-routes
    }
}
