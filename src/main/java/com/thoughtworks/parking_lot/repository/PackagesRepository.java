package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.core.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackagesRepository extends JpaRepository<Packages, Long> {

    @Query("Select p from Packages p where p.status = :status")
    List<Packages> findByStatus(@Param("status") String status);

}
