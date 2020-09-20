package com.altar.finance.loanservice.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.altar.finance.loanservice.component.profile.CustomerProfile;
import com.altar.finance.loanservice.component.profile.Imp.HighLevelProfile;
import com.altar.finance.loanservice.component.profile.Imp.LowLevelProfile;
import com.altar.finance.loanservice.component.profile.Imp.MediumLevelProfile;
import com.altar.finance.loanservice.configuration.AppProperties;
import com.altar.finance.loanservice.model.LoanApplication;

@Component
public class CustomerProfieFactory {
	
	@Autowired
	private  AppProperties properties;
	
	public CustomerProfile findCustomerProfile(LoanApplication app) {

		if (app.getCreditScore() > properties.getHighestCreditScore()) {
			return new HighLevelProfile(properties.getCreditMultiplier());
		} else if (isProfileB(app)) {
			return new MediumLevelProfile(properties.getDefaultMediumSegmentLimit());
		} else {
			return new LowLevelProfile();
		}

	}

	private boolean isProfileB(LoanApplication app) {
		return app.getCreditScore() > properties.getLowestCreditScore()
				&& app.getCreditScore() < properties.getHighestCreditScore()
				&& app.getMonthlyIncome().compareTo(properties.getMontlyIncomeLimit()) == -1;
	}

}
