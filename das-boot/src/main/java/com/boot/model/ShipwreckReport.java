package com.boot.model;

public class ShipwreckReport {
	private String name;
	private Integer depth;
	private Double latitude;
	private Double longitude;
	
	public ShipwreckReport(String name, Integer depth, Double latitude, Double longitude) {
		this.name = name;
		this.depth = depth;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public Integer getDepth() {
		return depth;
	}

	public Double getLatitude() {
		return latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
