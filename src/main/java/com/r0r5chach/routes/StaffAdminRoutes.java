package com.r0r5chach.routes;

import static com.r0r5chach.routes.Routes.restful;
import static spark.Spark.path;

import com.r0r5chach.services.generic.Service;

public class StaffAdminRoutes {
    private static Service service;
    public static void module() {
        path("/module", () -> {
            restful(service);

        });
    }

    public static void course() {
        path("/course", () -> {
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
