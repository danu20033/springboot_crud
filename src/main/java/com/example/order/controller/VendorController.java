package com.example.order.controller;

import com.example.order.entity.Vendor;
import com.example.order.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Vendor controller handle all api/vendors specific requests
 */
@RestController
public class VendorController {

    @Autowired
    private VendorService vendorService;

    /**
     * Create new vendors by given vendor details.
     *
     * @param vendor Vendor instance to be set
     * @return
     */
    @PostMapping("/api/vendors")
    public ResponseEntity<Void> create(@RequestBody Vendor vendor) {
        vendorService.create(vendor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Find Vendor by given id.
     *
     * @param id id of the vendor
     * @return matched Vendor
     */
    @GetMapping("/api/vendors/{id}")
    public ResponseEntity<Vendor> findById(@PathVariable Long id) {
        Vendor vendor = vendorService.findById(id);
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    }

    /**
     * Find Vendor by given name.
     *
     * @param name name of the vendor.
     * @return matched Vendor
     */
    @GetMapping("/api/vendors/findByName")
    public ResponseEntity<Vendor> findByName(@RequestParam String name) {
        Vendor vendor = vendorService.findByName(name);
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    }

    /**
     * Delete any given vendor by it's id.
     *
     * @param id id of the vendor
     * @return
     */
    @DeleteMapping("/api/vendors/{id}")
    public ResponseEntity<Vendor> delete(@PathVariable Long id) {
        vendorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Update Vendor by any given vendor details.
     *
     * @param vendor Vendor instance details to be set.
     * @return
     */
    @PutMapping("/api/vendors")
    public ResponseEntity<Void> update(@RequestBody Vendor vendor) {
        vendorService.update(vendor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Update partial data with given vendor detail.
     *
     * @param id id of the Vendor
     * @return
     */
    @PatchMapping("/api/vendor/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Vendor vendor) {
        vendorService.update(id, vendor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
