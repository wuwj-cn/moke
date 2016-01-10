package com.moke.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moke.cms.model.Company;
import com.moke.cms.service.CompanyManager;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	public CompanyManager companyManager;

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Company getCompany(@PathVariable  String id) {
		return companyManager.getCompany(id);
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public void saveCompany(Company company) {
		company.setName("moke工作室");
		company.setPhone("123456");
		company.setEmail("11@qq.com");
		companyManager.saveCompany(company);
	}
}
