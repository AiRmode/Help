package com.provectus.prodobro.service.actor;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.shared.status.Status;

import java.util.List;

public interface CompanyService {

    void makeRemovedById(Long id);

    Company getByTitle(String title);

    List<Company> getByStatus(Status status);
}
