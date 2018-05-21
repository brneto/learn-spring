package com.learning.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Account {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	@OneToMany(mappedBy = "account")
    private Set<Bookmark> bookmarks = new HashSet<>();
	
	public Account(final String username, final String password) {
        this.username = username;
        this.password = password;
    }
}
