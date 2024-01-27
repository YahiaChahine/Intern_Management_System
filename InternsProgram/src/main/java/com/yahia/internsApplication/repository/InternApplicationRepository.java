package com.yahia.internsApplication.repository;

import com.yahia.internsApplication.model.DesiredTrack;
import com.yahia.internsApplication.model.internApplication.InternApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InternApplicationRepository extends JpaRepository<InternApplication, Long> {
    List<InternApplication> getInternByUniversityNameOrderByGpa(String uni);
    List<InternApplication> getInternByUniversityNameAndTrackAndGpaGreaterThan(String uni, DesiredTrack track, float gpa);
    InternApplication getById(Long id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE applications SET application_acceptance = ?1 WHERE application_id = ?2", nativeQuery = true)
    Integer acceptInternById(boolean accept, Long id);

}
