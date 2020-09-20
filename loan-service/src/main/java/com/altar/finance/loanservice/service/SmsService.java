package com.altar.finance.loanservice.service;

import java.util.Locale;

public interface SmsService {

	  Object send(String from, String to, String template, Locale locale, Object[] args);
	}