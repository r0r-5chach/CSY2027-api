package com.r0r5chach.woodlands.routes;

import static com.r0r5chach.woodlands.routes.Routes.restful;
import static spark.Spark.path;

import com.r0r5chach.binaryMindsAPI.Service;
import com.r0r5chach.woodlands.services.StaffService;

public class StaffRoutes {
    private static Service service;

    public static void staff() {
        service = new StaffService();
        path("/staff", () -> {
            restful(service);
            //Route /staff/course/
            course();
            //Route /staff/module/
            module();
            //Route staff/timetable/
            timetable();
            //Route /staff/diary/
            diary();
        });
    }

    private static void module() {
        service = new StaffService.ModuleService();
        path("/module", () -> {
            restful(service);

        });
    }

    private static void course() {
        service = new StaffService.CourseService();
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
}
