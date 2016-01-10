package com.moke.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moke.cms.dao.CompanyDao;
import com.moke.cms.model.Company;
import com.moke.core.service.impl.BaseManager;

@Service
public class CompanyManagerImpl extends BaseManager implements CompanyManager {

	@Autowired
	public CompanyDao companyDao;
	
	@Override
	public Company getCompany(String id) {
		return companyDao.getCompany(id);
	}

	@Override
	public List<Company> getAllCompany() {
		return companyDao.getAllCompany();
	}

	@Override
	public void saveCompany(Company company) {
		companyDao.saveCompany(company);
	}

	@Override
	public void removeCompany(String id) {
		companyDao.removeCompany(id);
	}

	@Override
	public void updateCompany(Company company) {
		companyDao.updateCompany(company);
	}

}
