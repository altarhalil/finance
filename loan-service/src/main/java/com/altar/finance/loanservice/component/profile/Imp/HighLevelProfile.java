package com.altar.finance.loanservice.component.profile.Imp;

import java.math.BigDecimal;

import com.altar.finance.loanservice.component.profile.CustomerProfile;
import com.altar.finance.loanservice.model.enums.LoanApplicationStatus;

public class HighLevelProfile implements CustomerProfile {

	private int creditMultipler;

	public HighLevelProfile(int creditMultiplier) {
		this.creditMultipler = creditMultiplier;
	}

	@Override
	public BigDecimal calculateLimit(BigDecimal montlyIncome) {
		return montlyIncome.multiply(new BigDecimal(creditMultipler));
	}

	@Override
	public LoanApplicationStatus getCreditStatus() {
		return LoanApplicationStatus.ONAY;
	}

}
