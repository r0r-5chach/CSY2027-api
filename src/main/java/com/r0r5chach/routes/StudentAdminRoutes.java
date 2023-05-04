package com.r0r5chach.routes;

import static com.r0r5chach.routes.Routes.restful;
import static spark.Spark.path;

import com.r0r5chach.services.generic.Service;

public class StudentAdminRoutes {
    private static Service service;
    public static void enrol() {
        path("/enrol", () -> {
            restful(service);
        });
    }

    public static void grade() {
        path("/grade", () -> {
            restful(service);
        });
    }

    public static void attendance() {
        path("/attendance", () -> {
            restful(service);
        });
    }

    public static void timetable() {
        path("/timetable", () -> {
            restful(service);
        });
    }

    public static void diary() {
        path("/diary", () -> {
            restful(service);
        });
    }
}
