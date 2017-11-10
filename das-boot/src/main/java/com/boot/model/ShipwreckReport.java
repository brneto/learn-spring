package com.boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ShipwreckReport {
	private String name;
	private Integer depth;
	private Double latitude;
	private Double longitude;
}
