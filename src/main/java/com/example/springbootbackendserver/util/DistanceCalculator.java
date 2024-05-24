package com.example.springbootbackendserver.util;

import org.springframework.stereotype.Service;

@Service
public class DistanceCalculator {
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return 6371000 * c; // Radius of Earth in meters
    }

//    public double calculateDistance(double latitude, double longitude, String latitude1, String longitude1) {
//    }
}
