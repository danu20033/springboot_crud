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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class TransactionDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

/*    @ManyToOne
    @JoinColumn(name = "transaction_id" , nullable = false)
    private Transaction transaction;*/

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Enumerated(EnumType.ORDINAL)
    private UnitType productUnit;

    private Double quantity;

    private Double price;

    private Double totalAmount;

    private boolean transactionDetailStatus;

    private Long userId;

    private Long slNo;

    private Double gstRate;

    @Transient
    private Long productId;

}
