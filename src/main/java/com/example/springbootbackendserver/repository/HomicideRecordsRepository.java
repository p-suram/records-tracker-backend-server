package com.example.springbootbackendserver.repository;

import com.example.springbootbackendserver.entity.HomicideRecords;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomicideRecordsRepository extends JpaRepository<HomicideRecords, String> {
    List<HomicideRecords> findByAddressLatitudeBetweenAndAddressLongitudeBetween(double minLat, double maxLat, double minLon, double maxLon);}
