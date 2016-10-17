package com.provectus.prodobro.controller;

import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.service.actor.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/shelter")
public class ShelterController {
    private ShelterService shelterService;

    @Required
    @Autowired
    public void setUserService(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @RequestMapping(value = "/getById",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<Shelter> getUserById(HttpServletRequest req, @RequestParam Long id) {
            return new ResponseEntity<>(shelterService.getById(id), HttpStatus.OK);
    }


}
