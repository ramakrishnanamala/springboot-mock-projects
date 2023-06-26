package com.example.ContactManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ContactManagementSystem.entity.Person;
import com.example.ContactManagementSystem.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/save")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		return new ResponseEntity<Person>(contactService.createPerson(person), HttpStatusCode.valueOf(201));
	}

	@GetMapping("/retrieve/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") int id) {
		return new ResponseEntity<Person>(contactService.getPersonById(id), HttpStatusCode.valueOf(200));
	}
}
