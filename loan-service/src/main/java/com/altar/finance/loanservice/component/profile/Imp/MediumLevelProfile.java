package com.altar.finance.loanservice.component.profile.Imp;

import java.math.BigDecimal;

import com.altar.finance.loanservice.component.profile.CustomerProfile;
import com.altar.finance.loanservice.model.enums.LoanApplicationStatus;

public class MediumLevelProfile implements CustomerProfile {

	private BigDecimal defaultMediumSegmentLimit;

	public MediumLevelProfile(BigDecimal defaultMediumSegmentLimit) {
		this.defaultMediumSegmentLimit = defaultMediumSegmentLimit;
	}

	@Override
	public BigDecimal calculateLimit(BigDecimal limit) {
		return defaultMediumSegmentLimit;
	}

	@Override
	public LoanApplicationStatus getCreditStatus() {
		return LoanApplicationStatus.ONAY;
	}

}
