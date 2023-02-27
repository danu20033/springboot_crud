package com.example.order.repository;

import com.example.order.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Transaction Detail repository.
 */
@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {

}
