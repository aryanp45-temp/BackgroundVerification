package com.aryan.BackgroundVerification.Repository;

import com.aryan.BackgroundVerification.model.PccDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PccDetailsRepository extends JpaRepository<PccDetails,String> {
}
