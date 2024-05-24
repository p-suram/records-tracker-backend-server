package com.example.springbootbackendserver.controller;

import com.example.springbootbackendserver.entity.VehicularCrimesRecords;
import com.example.springbootbackendserver.service.VehicularCrimesRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicular-crimes-records")
public class VehicularCrimesRecordsController {

    @Autowired
    private VehicularCrimesRecordsService vehicularCrimesRecordsService;

    @PostMapping
    public ResponseEntity<VehicularCrimesRecords> createVehicularCrimesRecord(@RequestBody VehicularCrimesRecords vehicularCrimesRecord) {
        VehicularCrimesRecords createdRecord = vehicularCrimesRecordsService.createVehicularCrimesRecord(vehicularCrimesRecord);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicularCrimesRecords> getVehicularCrimesRecordById(@PathVariable String id) {
        VehicularCrimesRecords vehicularCrimesRecord = vehicularCrimesRecordsService.getVehicularCrimesRecordById(id);
        return new ResponseEntity<>(vehicularCrimesRecord, HttpStatus.OK);
    }
}

