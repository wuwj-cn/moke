package com.moke.cms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.moke.cms.dao.CompanyDao;
import com.moke.cms.model.Company;
import com.moke.core.dao.hibernate.BaseDaoHibernate;

@Repository
public class CompanyDaoImpl extends BaseDaoHibernate implements CompanyDao {

	@Override
	public Company getCompany(String id) {
		return (Company) this.getObject(Company.class, id);
	}
	
	@Override
	public Company findCompany(String id) {
		List<Company> list = this.find("from Company where id = ?", new Object[]{id});
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<Company> getAllCompany() {
		return this.getObjects(Company.class);
	}

	@Override
	public void saveCompany(Company company) {
		this.saveObject(company);
	}

	@Override
	public void removeCompany(String id) {
		this.removeObject(Company.class, id);
	}

	@Override
	public void updateCompany(Company company) {
		this.updateObject(company);
	}

}
