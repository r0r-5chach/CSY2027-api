package com.r0r5chach.woodlands.routes;

import static com.r0r5chach.woodlands.routes.Routes.restful;
import static spark.Spark.path;

import com.r0r5chach.binaryMindsAPI.services.Service;
import com.r0r5chach.woodlands.services.LessonService;
import com.r0r5chach.woodlands.services.RoomService;
import com.r0r5chach.woodlands.services.db.WoodlandsMDService;
import com.r0r5chach.woodlands.services.db.WoodlandsSDService;
public class AdminRoutes {
    private static Service service;

    public static void admin() {
        service = new Service();
        //Route /admin/
        path("/admin", () -> {
            //GET /admin/?token
            //POST /admin/?token
            //PUT /admin/?token
            //DELETE /admin/?token
            //OPTIONS /admin/?token
            restful(service);
            
            
            //Route /admin/db/
            db();

            //Route /admin/lessons
            lessons();

            //Route /admin/rooms
            rooms();
        });
    }

    private static void lessons() {
        service = new LessonService();
        path("/lessons", () -> {
            restful(service);
        });
    }

    private static void rooms() {
        service = new RoomService();
        path("/rooms", () -> {
            restful(service);
        });
    }
    
    private static void db() {
        service = new Service();
        //Route /db/
        path("/db", () -> {
            //GET /db/?token
            //POST /db/?token
            //PUT /db/?token
            //DELETE /db/?token
            //OPTIONS /db/?token
            restful(service);
            
            //Route /db/one/
            dbOne();
            //Route /db/many/
            dbMany();
        });
    }
    
    private static void dbOne() {
        service = new WoodlandsSDService();
        //Route /one/
        path("/one", () -> {
            //POST /one/?token&collection Create document
            //GET /one/?token&collection Read document
            //PUT /one/?token&collection Update document
            //DELETE /one/?token&collection Delete document
            //OPTIONS /one/?token
            restful(service);
        });
    }
    
    private static void dbMany() {
        service = new WoodlandsMDService();
        //Route /many/
        path("/many", () -> {
            //POST /many/?token&collection Create document
            //GET /many/?token&collection Read document
            //PUT /many/?token&collection Update document
            //DELETE /many/?token&collection Delete document
            //OPTIONS /many/?token
            restful(service);
        });
    }
}
