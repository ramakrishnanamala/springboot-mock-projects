package com.example.ContactManagementSystem.service;

import com.example.ContactManagementSystem.entity.Person;

public interface ContactService {
	
	Person createPerson(Person person);
	
	Person getPersonById(int id);

}
