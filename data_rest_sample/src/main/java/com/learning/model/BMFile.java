package com.learning.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class BMFile {
	@Id
	private Long id;
	
	private String name;
	private byte[] data;
	
	@OneToOne
	@MapsId
	@JoinColumn(foreignKey=@ForeignKey(name="FK_bookmark_bmfile"))
	private Bookmark bookmark;
}
