package com.altar.finance.loanservice.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.altar.finance.loanservice.model.enums.LoanApplicationStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Document(collection = "tutorials")
public class LoanApplication {
	
    @Id
    private UUID _id = UUID.randomUUID();
	private String idNumber;
	private String name;
	private String surName;
	private String msisdn;
	private BigDecimal monthlyIncome;
	private int creditScore;
	private BigDecimal credit;
	private LoanApplicationStatus status;
	private Timestamp nowDate = new Timestamp(System.currentTimeMillis());


}
