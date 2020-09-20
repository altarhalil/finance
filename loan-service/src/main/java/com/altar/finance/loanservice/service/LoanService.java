package com.altar.finance.loanservice.service;

import com.altar.finance.loanservice.model.LoanRequest;
import com.altar.finance.loanservice.model.LoanResponse;

public interface LoanService {

	LoanResponse applyForLoan(LoanRequest application);

}
