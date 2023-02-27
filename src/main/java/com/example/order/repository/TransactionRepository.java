package com.example.order.repository;

import com.example.order.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Transaction repository.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
