package com.example.order.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long invoiceId;

    private Long customerId;

    private Long userId;

    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;

    private LocalDateTime transactionDateTime;

    private Double totalBalance;

    private Double billBalance;

    private Double noBillBalance;

    private Long balanceAmount;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    private boolean transactionStatus;

    private Double gstRate;

    private Long paymentId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    private List<TransactionDetail> transactionDetails;

    @Transient
    private Long vendorId;
}
