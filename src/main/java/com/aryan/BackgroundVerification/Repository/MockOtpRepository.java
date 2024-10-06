package com.aryan.BackgroundVerification.Repository;

import com.aryan.BackgroundVerification.model.MockOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockOtpRepository extends JpaRepository<MockOtp, String > {
}
