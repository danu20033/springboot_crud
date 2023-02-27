package com.example.order.repository;

import com.example.order.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Vendor repository.
 */
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    @Query("select v from Vendor v where v.vendorName=?1")
    Vendor findByName(String name);
}
