package com.r0r5chach.woodlands.services;

import com.r0r5chach.binaryMindsAPI.services.APIService;
import com.r0r5chach.binaryMindsAPI.services.Service;
import com.r0r5chach.woodlands.services.db.WoodlandsSDService;

public class WoodlandsService extends APIService {
    protected Service service = new WoodlandsSDService();
}
