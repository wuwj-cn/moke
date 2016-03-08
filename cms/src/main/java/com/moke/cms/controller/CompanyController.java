package com.moke.cms.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moke.cms.model.Company;
import com.moke.cms.service.CompanyManager;
import com.moke.core.advice.Result;

@RestController
@RequestMapping("/company")
public class CompanyController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public CompanyManager companyManager;
	
	@RequestMapping(value = "/get", method= RequestMethod.POST)
	public Result get() {
		List<Company> list = companyManager.getAllCompany();
		Company company = null;
		if(null != list && !list.isEmpty()) {
			company = list.get(0);
		} else {
			company = new Company();
		}
		return Result.sucess(company);
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Result saveCompany(Company company) {
		if(company.getUuid().isEmpty()) company.setUuid(null);
		companyManager.saveCompany(company);
		return Result.sucess(company);
	}
}
