package com.example.GitHubEvents.service;

import java.util.List;
import java.util.Optional;

import com.example.GitHubEvents.entity.Events;

public interface EventsService {

	Events createEvent(Events events);

	List<Events> getAllEvents();

	List<Events> getAllByRepoId(int repoId);

	Optional<Events> findByEventId(int eventId);

}
