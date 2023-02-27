package com.example.order.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Vendor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorName;

    private String address;

    private String city;

    private String state;

    private int pinCode;

    @Enumerated(EnumType.ORDINAL)
    private VendorType vendorType;

    private boolean vendorStatus;

    private Long customerId;

    private String gstNumber;

    private Double totalBalance;

    private Double billBalance;

    private Double noBillBalance;


}
