package com.r0r5chach.woodlands.services;

public class StaffService extends WoodlandsService{
    protected static String collection = "staff";

    //TODO: Advanced endpoints
    //timetable service
    //diary service

    public static class CourseService extends WoodlandsService {
        protected static String collection = "courses";
    }

    public static class ModuleService extends WoodlandsService {
        protected static String collection = "modules";
        //needs auth function
    }
}
