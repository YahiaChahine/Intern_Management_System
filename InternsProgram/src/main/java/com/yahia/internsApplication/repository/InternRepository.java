package com.yahia.internsApplication.repository;

import com.yahia.internsApplication.model.intern.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long> {
}
