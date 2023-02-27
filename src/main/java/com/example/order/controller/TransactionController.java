package com.example.order.controller;

import com.example.order.entity.Transaction;
import com.example.order.service.TransactionService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 * Transaction controller handle all api/transactions specific requests
 */
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /**
     * Create new transaction by given transaction details.
     *
     * @param transaction Transaction instance to be set
     * @return
     */
    @PostMapping("/api/transactions")
    public ResponseEntity<Void> create(@RequestBody Transaction transaction) {
        transactionService.create(transaction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Find Transaction by given id.
     *
     * @param id id of the product
     * @return matched Transaction
     */
    @GetMapping("/api/transactions/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id) {
        Transaction transaction = transactionService.findById(id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }


    /**
     * Delete any given Transaction by it's id.
     *
     * @param id id of the Transaction
     * @return
     */
    @DeleteMapping("/api/transactions/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Update Transaction by any given Transaction details.
     *
     * @param transaction Transaction instance details to be set.
     * @return
     */
    @PutMapping("/api/transactions")
    public ResponseEntity<Void> update(@RequestBody Transaction transaction) {
        transactionService.update(transaction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Update partial data with given Transaction detail.
     *
     * @param id id of the Transaction
     * @return
     */
    @PatchMapping("/api/transaction/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Transaction transaction) {
        transactionService.update(id, transaction);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
