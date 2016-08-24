package com.provectus.prodobro.service.actor;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.service.GenericService;
import com.provectus.prodobro.shared.status.StatusEnum;

import java.util.List;

public interface CompanyService extends GenericService<Company, Long> {

    void makeRemovedById(Long id);

    Company getByTitle(String title);

    List<Company> getByStatus(StatusEnum status);

    List<Company> getByStatus(String status);
}
