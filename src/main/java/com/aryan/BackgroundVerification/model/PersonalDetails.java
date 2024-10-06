package com.aryan.BackgroundVerification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PersonalDetails {

    @Id
    private String aadharNumber;

    private String photo;
    private String name;
    private String dob;
    private String gender;
    private String address;
}