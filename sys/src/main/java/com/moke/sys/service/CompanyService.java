package com.moke.sys.service;

import com.moke.core.service.BaseService;
import com.moke.sys.model.Company;

public interface CompanyService extends BaseService {

	public Company getCompany();
	
	public void saveCompany(Company company);
	
	public void removeCompany(String id);
	
	public void updateCompany(Company company);
}
