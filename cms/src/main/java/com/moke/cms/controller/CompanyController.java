package com.moke.cms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moke.cms.model.Company;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Company getCompany(@PathVariable  String id) {
		return new Company(id, "moke");
	}
}
