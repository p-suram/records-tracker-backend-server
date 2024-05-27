package com.example.springbootbackendserver.controller;

import com.example.springbootbackendserver.entity.HomicideRecords;
import com.example.springbootbackendserver.entity.TheftRecords;
import com.example.springbootbackendserver.service.TheftRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theft-records")
public class TheftRecordsController {

    @Autowired
    private TheftRecordsService theftRecordsService;

    @PostMapping
    public ResponseEntity<TheftRecords> createTheftRecord(@RequestBody TheftRecords theftRecord) {
        TheftRecords createdRecord = theftRecordsService.createTheftRecord(theftRecord);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheftRecords> getTheftRecordById(@PathVariable String id) {
        TheftRecords theftRecord = theftRecordsService.getTheftRecordById(id);
        return new ResponseEntity<>(theftRecord, HttpStatus.OK);
    }

    @GetMapping("/records-in-radius")
    public List<TheftRecords> getTheftRecordsWithinRadius(@RequestParam double latitude,
                                                                @RequestParam double longitude,
                                                                @RequestParam double radiusInMiles) throws InterruptedException {
        return theftRecordsService.getTheftRecordsWithinRadius(latitude, longitude, radiusInMiles);
    }
}

