package com.example.ContactManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ContactManagementSystem.entity.Person;
import com.example.ContactManagementSystem.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;
	
	public Person createPerson(Person person) {
		return contactRepository.save(person);
	}
	
	public Person getPersonById(int id) {
		return contactRepository.findById(id).get();
	}
	
}
