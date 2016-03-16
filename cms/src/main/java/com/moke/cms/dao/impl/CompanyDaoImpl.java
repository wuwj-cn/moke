package com.moke.cms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.moke.cms.dao.CompanyDao;
import com.moke.cms.model.Company;
import com.moke.core.dao.hibernate.BaseDaoHibernate;

@SuppressWarnings("unchecked")
@Repository
public class CompanyDaoImpl extends BaseDaoHibernate implements CompanyDao {

	@Override
	public Company getCompany() {
		List<Company> list = this.getObjects(Company.class);
		Company company = null;
		if(null != list && !list.isEmpty()) {
			company = list.get(0);
		} else {
			company = new Company();
		}
		return company;
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
