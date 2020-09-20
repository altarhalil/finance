package com.altar.finance.loanservice.component.profile.Imp;

import java.math.BigDecimal;

import com.altar.finance.loanservice.component.profile.CustomerProfile;
import com.altar.finance.loanservice.model.enums.LoanApplicationStatus;

public class LowLevelProfile implements CustomerProfile {

	@Override
	public BigDecimal calculateLimit(BigDecimal limit) {
		return new BigDecimal(0);
	}

	@Override
	public LoanApplicationStatus getCreditStatus() {
		// TODO Auto-generated method stub
		return LoanApplicationStatus.RED;
	}

}
