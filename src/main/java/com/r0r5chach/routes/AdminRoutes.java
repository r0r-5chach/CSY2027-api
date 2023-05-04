package com.r0r5chach.routes;

import static com.r0r5chach.routes.Routes.restful;
import static spark.Spark.path;

import com.r0r5chach.services.AdminService;
import com.r0r5chach.services.generic.MultipleDocumentService;
import com.r0r5chach.services.generic.Service;
import com.r0r5chach.services.generic.SingleDocumentService;
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
            
            //Route /admin/course/
            course();
            //Route /admin/module/
            module();
            //Route /admin/student/
            student();
            //Route /admin/staff/
            staff();
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
        service = new SingleDocumentService();
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
        service = new MultipleDocumentService();
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
    
    private static void course() {
        service = new AdminService.CourseService();
        path("/course", () -> {
            //POST /course/?token Create course
            //GET /course/?token Read course
            //PUT /course/?token Update course
            //DELETE /course/?token Delete document
            //OPTIONS /course/?token
            restful(service);
        });
    }
    
    private static void module() {
        service = new AdminService.ModuleService();
        path("/module", () -> {
            restful(service);
        });
    }
    
    private static void student() {
        path("/student", () -> {
            restful(service);
            //Route /student/enrol/
            StudentAdminRoutes.enrol();
            //Route /student/grade/
            StudentAdminRoutes.grade();
            //Route /student/attendance/
            StudentAdminRoutes.attendance();
            //Route /student/timetable/
            StudentAdminRoutes.timetable();
            //Route /student/diary/
            StudentAdminRoutes.diary();
        });
    }
    
    private static void staff() {
        path("/staff", () -> {
            restful(service);
            //Route /staff/course/
            StaffAdminRoutes.course();
            //Route /staff/module/
            StaffAdminRoutes.module();
            //Route staff/timetable/
            StaffAdminRoutes.timetable();
            //Route /staff/diary/
            StaffAdminRoutes.diary();
        });
    }
}
