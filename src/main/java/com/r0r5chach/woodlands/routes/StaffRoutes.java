package com.r0r5chach.woodlands.routes;

import static com.r0r5chach.woodlands.routes.Routes.restful;
import static spark.Spark.before;
import static spark.Spark.path;

import com.r0r5chach.binaryMindsAPI.services.Service;
import com.r0r5chach.woodlands.services.StaffService;
import com.r0r5chach.woodlands.services.db.WoodlandsSDService;

public class StaffRoutes {
    private static Service service;

    public static void staff() {
        service = new StaffService();
        path("/staff", () -> {
            restful(service);
            //Route /staff/course/
            before("/course/*", StaffService::cdAuth);
            course();
            //Route /staff/module/
            before("/module/*", StaffService::cdAuth);
            module();
            //Route staff/timetable/
            timetable();
            //Route /staff/diary/
            diary();
            //Route /staff/assignments
            assignments();
        });
    }

    private static void module() {
        service = new WoodlandsSDService("modules");
        path("/module", () -> {
            restful(service);

        });
    }

    private static void course() {
        service = new WoodlandsSDService("courses");
        path("/course", () -> {
            restful(service);

        });
    }

    private static void timetable() {
        path("/timetable", () -> {
            restful(service);
        });
    }

    private static void diary() {
        path("/diary", () -> {
            restful(service);

        });
    }

    private static void assignments() {
        service = new WoodlandsSDService("assignments");
        path("/assignments", () -> {
            restful(service);
        });
    }
}
