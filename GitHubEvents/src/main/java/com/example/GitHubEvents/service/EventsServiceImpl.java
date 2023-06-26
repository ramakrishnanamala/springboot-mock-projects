package com.example.GitHubEvents.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GitHubEvents.entity.Events;
import com.example.GitHubEvents.repository.EventsRepository;

@Service
public class EventsServiceImpl implements EventsService {
	
	@Autowired
	EventsRepository eventsRepository;
	
	@Override
	public Events createEvent(Events events) {
		return eventsRepository.save(events);
	}

	@Override
	public List<Events> getAllEvents() {
		return eventsRepository.findAll();
	}

	@Override
	public List<Events> getAllByRepoId(int repoId) {
		return eventsRepository.findByRepoId(repoId);
	}

	@Override
	public Optional<Events> findByEventId(int eventId) {
		return eventsRepository.findById(eventId);
	}
	
}
