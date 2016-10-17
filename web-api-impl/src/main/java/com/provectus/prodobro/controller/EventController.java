package com.provectus.prodobro.controller;

import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.service.actor.EventService;
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
@RequestMapping("/event")
public class EventController {

    private EventService eventService;

    @Required
    @Autowired
    public void setUserService(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/getById",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<Event> getUserById(HttpServletRequest req, @RequestParam Long id) {
            return new ResponseEntity<>(eventService.getById(id), HttpStatus.OK);
    }


}
