package com.example.springbootbackendserver.controller;

import com.example.springbootbackendserver.entity.DrugRelatedCrimesRecords;
import com.example.springbootbackendserver.service.DrugRelatedCrimesRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drug-related-crimes-records")
public class DrugRelatedCrimesRecordsController {

    @Autowired
    private DrugRelatedCrimesRecordsService drugRelatedCrimesRecordsService;

    @PostMapping
    public ResponseEntity<DrugRelatedCrimesRecords> createDrugRelatedCrimesRecord(@RequestBody DrugRelatedCrimesRecords drugRelatedCrimesRecord) {
        DrugRelatedCrimesRecords createdRecord = drugRelatedCrimesRecordsService.createDrugRelatedCrimesRecord(drugRelatedCrimesRecord);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrugRelatedCrimesRecords> getDrugRelatedCrimesRecordById(@PathVariable String id) {
        DrugRelatedCrimesRecords drugRelatedCrimesRecord = drugRelatedCrimesRecordsService.getDrugRelatedCrimesRecordById(id);
        return new ResponseEntity<>(drugRelatedCrimesRecord, HttpStatus.OK);
    }
}

