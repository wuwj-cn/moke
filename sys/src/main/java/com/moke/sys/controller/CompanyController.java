package com.moke.sys.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moke.core.advice.Result;
import com.moke.sys.model.Company;
import com.moke.sys.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public CompanyService companyService;
	
	@RequestMapping(value = "/get", method= RequestMethod.POST)
	public Result get() {
		Company company = companyService.getCompany();
		return Result.sucess(company);
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Result saveCompany(Company company) {
		if(company.getUuid().isEmpty()) company.setUuid(null);
		companyService.saveCompany(company);
		return Result.sucess(company);
	}
}
