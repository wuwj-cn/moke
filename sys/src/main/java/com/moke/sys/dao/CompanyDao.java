package com.moke.sys.dao;

import com.moke.core.dao.Dao;
import com.moke.sys.model.Company;

public interface CompanyDao extends Dao {

	public Company getCompany();
	
	public void saveCompany(Company company);
	
	public void removeCompany(String id);
	
	public void updateCompany(Company company);
}
