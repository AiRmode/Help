package com.provectus.prodobro.controller;

import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.service.actor.CompanyService;
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
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    @Required
    @Autowired
    public void setUserService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/getById",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<Company> getUserById(HttpServletRequest req, @RequestParam Long id) {
            return new ResponseEntity<>(companyService.getById(id), HttpStatus.OK);
    }


}
