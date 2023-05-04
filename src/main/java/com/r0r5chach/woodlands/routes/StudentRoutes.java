package com.r0r5chach.woodlands.routes;

import static com.r0r5chach.woodlands.routes.Routes.restful;
import static spark.Spark.path;

import com.r0r5chach.binaryMindsAPI.services.Service;
import com.r0r5chach.woodlands.services.student.StudentService;

public class StudentRoutes {
    private static Service service;
    
    public static void student() {
        service = new StudentService();
        path("/student", () -> {
            restful(service);
            //Route /student/enrol/
            enrol();
            //Route /student/grade/
            grade();
            //Route /student/attendance/
            attendance();
            //Route /student/timetable/
            timetable();
            //Route /student/diary/
            diary();
        });
    }
    private static void enrol() {
        path("/enrol", () -> {
            restful(service);
        });
    }

    private static void grade() {
        path("/grade", () -> {
            restful(service);
        });
    }

    private static void attendance() {
        path("/attendance", () -> {
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
