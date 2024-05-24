package com.example.springbootbackendserver.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Data
@MappedSuperclass
public class Records {
    @Id
    private String id = UUID.randomUUID().toString();

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String middleName;
    @NotNull
    private int age;
    @NotNull
    private String dob;
    @Embedded
    @NotNull
    private Address address;
}
