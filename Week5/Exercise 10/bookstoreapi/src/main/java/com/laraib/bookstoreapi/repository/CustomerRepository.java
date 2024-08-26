package com.mansoor.bookstoreapi.repository;

import com.mansoor.bookstoreapi.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

