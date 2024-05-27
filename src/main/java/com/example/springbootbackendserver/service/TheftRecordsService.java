package com.example.springbootbackendserver.service;

import com.example.springbootbackendserver.entity.HomicideRecords;
import com.example.springbootbackendserver.entity.TheftRecords;
import com.example.springbootbackendserver.repository.TheftRecordsRepository;
import com.example.springbootbackendserver.util.DistanceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheftRecordsService {

    @Autowired
    private TheftRecordsRepository theftRecordsRepository;

    @Autowired
    private DistanceCalculator calculator;

    public TheftRecords createTheftRecord(TheftRecords theftRecord) {
        return theftRecordsRepository.save(theftRecord);
    }

    public TheftRecords getTheftRecordById(String id) {
        return theftRecordsRepository.findById(id).orElse(null);
    }

    public List<TheftRecords> getTheftRecordsWithinRadius(double latitude, double longitude, double radiusInMiles) throws InterruptedException {
        double radiusInMeters = radiusInMiles * 1609.34;

        // Calculate the bounding box coordinates
        double maxLat = latitude + Math.toDegrees(radiusInMeters / 6371000);
        double minLat = latitude - Math.toDegrees(radiusInMeters / 6371000);
        double degrees = Math.toDegrees(Math.asin(radiusInMeters / 6371000) / Math.cos(Math.toRadians(latitude)));
        double maxLon = longitude + degrees;
        double minLon = longitude - degrees;

        // Query the database for records within the bounding box
        List<TheftRecords> recordsWithinBoundingBox = theftRecordsRepository.findByAddressLatitudeBetweenAndAddressLongitudeBetween(minLat, maxLat, minLon, maxLon);

        // Filter the records to get those within the specified radius
        Thread.sleep(30000);
        System.out.println("sending teft response now");

        return recordsWithinBoundingBox.stream()
                .filter(record -> calculator.calculateDistance(latitude, longitude, record.getAddress().getLatitude(), record.getAddress().getLongitude()) <= radiusInMeters)
                .toList();
    }
}

