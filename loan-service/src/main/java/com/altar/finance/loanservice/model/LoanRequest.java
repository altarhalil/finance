package com.altar.finance.loanservice.model;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {

	@Size(min = 11, max = 11, message = "Identidy number must be 11 digits.")
	private String idNumber;

	@NotBlank(message = "Name is not blank.")
	private String name;

	@NotBlank(message = "Surname is not blank.")
	private String surName;

	@NotBlank(message = "Msisdn is not blank.")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number format is wrong.")
	private String msisdn;

	@Digits(integer = 8, fraction = 2, message = "Monthly income format is wrong.")
	private BigDecimal monthlyIncome;

}