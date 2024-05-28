package com.example.springbootbackendserver.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="homicide_records")
public class HomicideRecords extends Records{
    @Embedded
    private HomicideCaseDetail caseDetail;
}
