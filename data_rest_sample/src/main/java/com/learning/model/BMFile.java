package com.learning.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class BMFile {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private byte[] data;
	
	@OneToOne
	private Bookmark bookmark;
}