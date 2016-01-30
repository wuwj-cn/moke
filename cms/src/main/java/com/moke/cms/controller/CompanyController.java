package com.moke.cms.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moke.cms.model.Company;
import com.moke.cms.service.CompanyManager;
import com.moke.core.advice.Response;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	public CompanyManager companyManager;
	
	@RequestMapping(method= RequestMethod.GET)
	public Company get() {
		return companyManager.getAllCompany().get(0);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Company getCompany(@PathVariable  String id) {
		return companyManager.getCompany(id);
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public Response saveCompany(Company company) {
		if(company.getUuid().isEmpty()) {
			company.setUuid(null);
		}
		companyManager.saveCompany(company);
		return new Response().success(company);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	public Company updateCompany(Company company, @PathVariable String id) {
		Company po = companyManager.findCompany(id);
		BeanUtils.copyProperties(company, po);
		companyManager.updateCompany(po);
		return company;
	}
}
