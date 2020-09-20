package com.altar.finance.loanservice.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.altar.finance.loanservice.component.profile.CustomerProfile;
import com.altar.finance.loanservice.model.LoanApplication;

@Component
public class CustomerProfileValidation {

	@Autowired
	CustomerProfieFactory factory;

	public LoanApplication validate(LoanApplication application) {
		CustomerProfile customerProfile = factory.findCustomerProfile(application);
		application.setCredit(customerProfile.calculateLimit(application.getMonthlyIncome()));
		application.setStatus(customerProfile.getCreditStatus());
		return application;
	}

}
