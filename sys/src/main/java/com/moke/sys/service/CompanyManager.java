package com.moke.sys.service;

import com.moke.core.service.Manager;
import com.moke.sys.model.Company;

public interface CompanyManager extends Manager {

	public Company getCompany();
	
	public void saveCompany(Company company);
	
	public void removeCompany(String id);
	
	public void updateCompany(Company company);
}
