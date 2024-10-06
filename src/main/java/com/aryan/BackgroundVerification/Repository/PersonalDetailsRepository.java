package com.aryan.BackgroundVerification.Repository;

import com.aryan.BackgroundVerification.model.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, String> {

}
