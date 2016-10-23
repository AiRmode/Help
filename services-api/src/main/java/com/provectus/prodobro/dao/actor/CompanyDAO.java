package com.provectus.prodobro.dao.actor;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.dao.GenericDAO;
import com.provectus.prodobro.shared.StatusEnum;

import java.util.List;

public interface CompanyDAO extends GenericDAO<Company, Long> {

	Company getByTitle(String title);

	List<Company> getByStatus(StatusEnum status);
}
