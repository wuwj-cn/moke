package com.moke.cms.service;

import com.moke.cms.model.Company;
import com.moke.core.service.Manager;

public interface CompanyManager extends Manager {

	public Company getCompany();
	
	public void saveCompany(Company company);
	
	public void removeCompany(String id);
	
	public void updateCompany(Company company);
}
