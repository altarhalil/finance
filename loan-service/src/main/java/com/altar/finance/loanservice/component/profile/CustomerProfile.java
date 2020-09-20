package com.altar.finance.loanservice.component.profile;

import java.math.BigDecimal;

import com.altar.finance.loanservice.model.enums.LoanApplicationStatus;

public interface CustomerProfile {

	BigDecimal calculateLimit(BigDecimal limit);

	LoanApplicationStatus getCreditStatus();

}
