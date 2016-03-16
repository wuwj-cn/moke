package com.moke.cms.dao;

import com.moke.cms.model.Company;
import com.moke.core.dao.Dao;

public interface CompanyDao extends Dao {

	public Company getCompany();
	
	public void saveCompany(Company company);
	
	public void removeCompany(String id);
	
	public void updateCompany(Company company);
}
