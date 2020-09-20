package com.altar.finance.loanservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altar.finance.loanservice.model.LoanRequest;
import com.altar.finance.loanservice.model.LoanResponse;
import com.altar.finance.loanservice.service.LoanService;

@RestController
@RequestMapping(value = "/loans")
public class LoanController {

	@Autowired
	private LoanService loanService;

	@PostMapping(value = "/apply", produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanResponse applyForLoan(@Valid @RequestBody LoanRequest request) {
		LoanResponse response = loanService.applyForLoan(request);
		return response;
	}

}
