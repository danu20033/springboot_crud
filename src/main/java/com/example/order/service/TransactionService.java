package com.example.order.service;

import com.example.order.entity.Product;
import com.example.order.entity.Transaction;
import com.example.order.entity.TransactionDetail;
import com.example.order.entity.Vendor;
import com.example.order.repository.ProductRepository;
import com.example.order.repository.TransactionRepository;
import com.example.order.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private ProductRepository productRepository;

    public void create(Transaction transaction) {

        //set vendor
        Long vendorId = transaction.getVendorId();
        Optional<Vendor> vendor = vendorRepository.findById(vendorId);
        vendor.ifPresent(vendor1 -> transaction.setVendor(vendor1));
        vendor.orElseThrow(() -> new IllegalArgumentException("Vendor is not available with given id :" + vendorId));

        handleTransactionDetails(transaction);

        transactionRepository.save(transaction);
    }

    private void handleTransactionDetails(Transaction transaction) {

        List<TransactionDetail> transactionDetailList = transaction.getTransactionDetails();

        transactionDetailList.stream().forEach(detail -> {

            Long productId = detail.getProductId();
            Optional<Product> product = productRepository.findById(productId);

            product.ifPresent(product1 -> detail.setProduct(product1));
            product.orElseThrow(() -> new IllegalArgumentException("Product is not available with given id :" + productId));


        });


    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Transaction is not found with Id : " + id));
    }


    public void delete(Long id) {

        transactionRepository.deleteById(id);
    }

    public void update(Transaction transaction) {
        if (transaction.getId() == null) {
            throw new IllegalArgumentException("Update operation should have an Id.");
        }
        transactionRepository.save(transaction);
    }

    public void update(Long id, Transaction transaction) {
        Optional<Transaction> loaded = transactionRepository.findById(id);
        loaded.orElseThrow(() -> new IllegalArgumentException("Transaction is not found"));

        Transaction updatedTransaction = loaded.get();
        updatedTransaction.setBalanceAmount(transaction.getBalanceAmount());
        updatedTransaction.setCustomerId(transaction.getCustomerId());


        transactionRepository.save(updatedTransaction);
    }
}
