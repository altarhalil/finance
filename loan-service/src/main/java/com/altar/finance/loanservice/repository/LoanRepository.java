package com.altar.finance.loanservice.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.altar.finance.loanservice.model.LoanApplication;

public interface LoanRepository extends MongoRepository<LoanApplication, UUID> {

}
