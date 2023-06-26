package com.example.GitHubEvents.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GitHubEvents.entity.Events;
import com.example.GitHubEvents.service.EventsService;

@RestController
public class EventController {
	@Autowired
    EventsService eventsService;

    @PostMapping("/events")
    public ResponseEntity<Events> createEvent(@RequestBody Events events){
       Events eventsSave = eventsService.createEvent(events);
        return  new ResponseEntity<>(eventsSave, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/events")
    public ResponseEntity<List<Events>> getAllEvents(){
        List<Events> eventsList = eventsService.getAllEvents();
        return  new ResponseEntity<>(eventsList, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/repos/{repoId}/events")
    public ResponseEntity<List<Events>> getAllByRepoId(@PathVariable int repoId){
        List<Events> eventsList = eventsService.getAllByRepoId(repoId);
        return  new ResponseEntity<>(eventsList, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/events/{eventId}")
    public ResponseEntity<Optional<Events>> getAllByEvent(@PathVariable int eventId){
        Optional<Events> event = eventsService.findByEventId(eventId);
        if(event.isPresent()){
            return  new ResponseEntity<>(event, HttpStatusCode.valueOf(200));
        }

        return new ResponseEntity<>(HttpStatusCode.valueOf(404));

    }
}
