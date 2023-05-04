package com.r0r5chach.services;

import com.r0r5chach.services.generic.APIService;

public class AdminService {
    public static class CourseService extends APIService {
        protected static String collection = "courses";
    }

    public static class ModuleService extends APIService {
        protected static String collection = "modules";
    }
}
