package com.provectus.prodobro.service;


import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.shelter.ShelterTypeEnum;
import com.provectus.prodobro.dao.actor.ShelterDAO;
import com.provectus.prodobro.service.actor.ShelterService;
import com.provectus.prodobro.shared.StatusEnumNew;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("shelterService")
public class ShelterServiceImpl implements ShelterService {

    private ShelterDAO shelterDAO;

    @Override
    public void save(Shelter object) {
        shelterDAO.save(object);
    }

    @Override
    public Shelter getById(Long id) {
        return shelterDAO.getById(id);
    }

    @Override
    public void update(Shelter object) {
        shelterDAO.update(object);
    }

    /**
     * Removing shelter is deprecated
     * Use makeRemovedById()
     *
     * @param object Shelter
     */
    @Deprecated
    @Override
    public void remove(Shelter object) {
        shelterDAO.remove(object);
    }

    @Override
    public List<Shelter> getAll() {
        return shelterDAO.getAll();
    }

    @Override
    public void makeRemovedById(Long id) {
        Shelter company = shelterDAO.getById(id);
        company.setStatus(StatusEnumNew.DELETED);
        shelterDAO.update(company);
    }

    @Override
    public Shelter getByTitle(String title) {
        return shelterDAO.getByTitle(title);
    }

    @Override
    public List<Shelter> getByStatus(StatusEnumNew status) {
        return shelterDAO.getByStatus(status);
    }

    @Override
    public List<Shelter> getByType(String type) {
        return shelterDAO.getByType(type);
    }

    @Override
    public List<Shelter> getByType(ShelterTypeEnum type) {
        return shelterDAO.getByType(type);
    }

    @Required
    @Resource(name = "shelterDAO")
    public void setCompanyDAO(ShelterDAO shelterDAO) {
        this.shelterDAO = shelterDAO;
    }
}
