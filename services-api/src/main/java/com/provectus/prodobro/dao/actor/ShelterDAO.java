package com.provectus.prodobro.dao.actor;


import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.shelter.ShelterTypeEnum;
import com.provectus.prodobro.dao.GenericDAO;
import com.provectus.prodobro.shared.StatusEnumNew;

import java.util.List;

public interface ShelterDAO extends GenericDAO<Shelter, Long> {

    Shelter getByTitle(String title);

    List<Shelter> getByStatus(StatusEnumNew status);

    List<Shelter> getByType(String type);

    List<Shelter> getByType(ShelterTypeEnum type);
}
