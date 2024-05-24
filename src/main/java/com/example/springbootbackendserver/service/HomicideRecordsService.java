package com.example.springbootbackendserver.service;

import com.example.springbootbackendserver.entity.HomicideCaseDetail;
import com.example.springbootbackendserver.entity.HomicideRecords;
import com.example.springbootbackendserver.repository.HomicideRecordsRepository;
import com.example.springbootbackendserver.util.DistanceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomicideRecordsService {

    @Autowired
    private HomicideRecordsRepository homicideRecordsRepository;

    @Autowired
    private DistanceCalculator calculator;

    public HomicideRecords createHomicideRecord(HomicideRecords homicideRecord) {
        return homicideRecordsRepository.save(homicideRecord);
    }

    public HomicideRecords getHomicideRecordById(String id) {
        return homicideRecordsRepository.findById(id).orElse(null);
    }

    public List<HomicideRecords> getHomicideRecordsWithinRadius(double latitude, double longitude, double radiusInMiles) {
        double radiusInMeters = radiusInMiles * 1609.34;

        // Calculate the bounding box coordinates
        double maxLat = latitude + Math.toDegrees(radiusInMeters / 6371000);
        double minLat = latitude - Math.toDegrees(radiusInMeters / 6371000);
        double degrees = Math.toDegrees(Math.asin(radiusInMeters / 6371000) / Math.cos(Math.toRadians(latitude)));
        double maxLon = longitude + degrees;
        double minLon = longitude - degrees;

        // Query the database for records within the bounding box
        List<HomicideRecords> recordsWithinBoundingBox = homicideRecordsRepository.findByAddressLatitudeBetweenAndAddressLongitudeBetween(minLat, maxLat, minLon, maxLon);

        // Filter the records to get those within the specified radius

        return recordsWithinBoundingBox.stream()
                .filter(record -> calculator.calculateDistance(latitude, longitude, record.getAddress().getLatitude(), record.getAddress().getLongitude()) <= radiusInMeters)
                .toList();
    }

}

