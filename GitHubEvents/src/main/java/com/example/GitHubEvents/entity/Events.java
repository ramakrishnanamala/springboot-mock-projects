package com.example.GitHubEvents.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String type;
	
	@Column(name = "public")
	private Boolean Public;
	
	@Column
	private int repoId;
	
	@Column
	private int actorId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getPublic() {
		return Public;
	}

	public void setPublic(Boolean public1) {
		Public = public1;
	}

	public int getRepoId() {
		return repoId;
	}

	public void setRepoId(int repoId) {
		this.repoId = repoId;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	@Override
	public String toString() {
		return "Events [id=" + id + ", type=" + type + ", Public=" + Public + ", repoId=" + repoId + ", actorId="
				+ actorId + "]";
	}
	
}
