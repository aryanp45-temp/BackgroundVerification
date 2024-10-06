package com.aryan.BackgroundVerification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PccDetails {
    @Id
    private String applicationId;

    private String phoneNumber;

    private String policeStationLocation;
}
