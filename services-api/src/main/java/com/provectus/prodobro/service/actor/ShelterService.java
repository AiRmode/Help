package com.provectus.prodobro.service.actor;


import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.shelter.ShelterType;
import com.provectus.prodobro.shared.status.Status;

import java.util.List;

public interface ShelterService {

    void makeRemovedById(Long id);

    Shelter getByTitle(String title);

    List<Shelter> getByStatus(Status status);

    List<Shelter> getByType(ShelterType type);
}
