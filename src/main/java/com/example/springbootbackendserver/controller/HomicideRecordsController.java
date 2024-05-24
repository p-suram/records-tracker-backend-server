package com.example.springbootbackendserver.controller;

import com.example.springbootbackendserver.entity.HomicideRecords;
import com.example.springbootbackendserver.service.HomicideRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homicide-records")
public class HomicideRecordsController {

    @Autowired
    private HomicideRecordsService homicideRecordsService;

    @PostMapping
    public ResponseEntity<HomicideRecords> createHomicideRecord(@RequestBody HomicideRecords homicideRecord) {
        HomicideRecords createdRecord = homicideRecordsService.createHomicideRecord(homicideRecord);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HomicideRecords> getHomicideRecordById(@PathVariable String id) {
        HomicideRecords homicideRecord = homicideRecordsService.getHomicideRecordById(id);
        return new ResponseEntity<>(homicideRecord, HttpStatus.OK);
    }

    @GetMapping("/records-in-radius")
    public List<HomicideRecords> getHomicideRecordsWithinRadius(@RequestParam double latitude,
                                                                @RequestParam double longitude,
                                                                @RequestParam double radiusInMiles) {
        return homicideRecordsService.getHomicideRecordsWithinRadius(latitude, longitude, radiusInMiles);
    }
}

