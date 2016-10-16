package com.provectus.prodobro.service.actor;


import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.shelter.ShelterTypeEnum;
import com.provectus.prodobro.service.GenericService;
import com.provectus.prodobro.shared.StatusEnumNew;

import java.util.List;

public interface ShelterService extends GenericService<Shelter, Long> {

    void makeRemovedById(Long id);

    Shelter getByTitle(String title);

    List<Shelter> getByStatus(StatusEnumNew status);

    List<Shelter> getByType(ShelterTypeEnum type);

    List<Shelter> getByType(String type);
}
