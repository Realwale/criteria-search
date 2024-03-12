package com.olawale.criteriasearch.repository;

import com.olawale.criteriasearch.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ResidentRepository extends JpaRepository<Resident, Long>, JpaSpecificationExecutor<Resident> {
    Optional<Resident> findByEmail(String email);

    boolean existsByEmail(String email);
}
