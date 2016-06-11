package com.moke.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moke.core.service.impl.BaseServiceImpl;
import com.moke.sys.dao.CompanyDao;
import com.moke.sys.model.Company;
import com.moke.sys.service.CompanyService;

@Service
public class CompanyServiceImpl extends BaseServiceImpl implements CompanyService {

	@Autowired
	public CompanyDao companyDao;
	
	@Override
	public Company getCompany() {
		return companyDao.getCompany();
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
