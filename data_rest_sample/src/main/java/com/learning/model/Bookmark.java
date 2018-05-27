package com.learning.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Bookmark {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Account account;

  private String uri;
  private String description;
    
  public Bookmark(final Account account, final String uri, final String description) {
  	this.account = account;
  	this.uri = uri;
  	this.description = description;
  }

  public static Bookmark from(Account account, Bookmark bookmark) {
	 return new Bookmark(account, bookmark.uri, bookmark.getDescription());
  }
}
