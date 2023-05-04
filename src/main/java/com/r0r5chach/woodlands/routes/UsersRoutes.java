package com.r0r5chach.woodlands.routes;

import static com.r0r5chach.woodlands.routes.Routes.restful;
import static spark.Spark.path;

import com.r0r5chach.binaryMindsAPI.services.Service;
import com.r0r5chach.woodlands.services.UsersService;

public class UsersRoutes {
    private static Service service;
    public static void users() {
        service = new UsersService();
        //Route /users/
        path("/users", () -> {
            //GET /users/?token&user must be same user as edited user or admin
            //POST /users/?token&user admin auth
            //PUT /users/?token&user must be same user as edited user or admin
            //DELETE /users/?token&user admin auth
            //OPTIONS /users/>?token
            restful(service);
        });
    }
    
}
