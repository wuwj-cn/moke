package com.moke.cms.dao;

import java.util.List;

import com.moke.cms.model.Company;
import com.moke.core.dao.Dao;

public interface CompanyDao extends Dao {

	public Company getCompany(String id);
	
	public Company findCompany(String id);
	
	public List<Company> getAllCompany();
	
	public void saveCompany(Company company);
	
	public void removeCompany(String id);
	
	public void updateCompany(Company company);
}
