package com.example.order.service;

import com.example.order.entity.Vendor;
import com.example.order.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Vendor Service to be used handle all service specific business rules.
 */
@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;


    public void create(Vendor vendor) {

        vendorRepository.save(vendor);
    }

    public Vendor findById(Long id) {
        return vendorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Vendor is not found with Id : " + id));
    }

    public Vendor findByName(String name) {
        return vendorRepository.findByName(name);
    }

    public void delete(Long id) {

        vendorRepository.deleteById(id);
    }

    public void update(Vendor vendor) {
        if (vendor.getId() == null) {
            throw new IllegalArgumentException("Update operation should have an Id.");
        }
        vendorRepository.save(vendor);
    }

    public void update(Long id, Vendor vendor) {

        Optional<Vendor> loaded = vendorRepository.findById(id);
        loaded.orElseThrow(() -> new IllegalArgumentException("Vendor is not found"));

        Vendor updatedVendor = loaded.get();
        updatedVendor.setVendorName(vendor.getVendorName());
        updatedVendor.setVendorStatus(vendor.isVendorStatus());

        vendorRepository.save(updatedVendor);
    }
}
