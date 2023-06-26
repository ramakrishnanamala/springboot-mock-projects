package com.example.GitHubEvents.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GitHubEvents.entity.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {

	List<Events> findByRepoId(int repoId);

}
