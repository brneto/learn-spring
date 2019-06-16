package com.example.demo.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileFormModel {
	 private String name;
	 private MultipartFile file;
}
