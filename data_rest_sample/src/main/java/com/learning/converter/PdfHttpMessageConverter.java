package com.learning.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.ResourceHttpMessageConverter;

public class PdfHttpMessageConverter extends ResourceHttpMessageConverter {
	private final List<MediaType> mediaTypes = new ArrayList<>();
	
	public PdfHttpMessageConverter() {
		mediaTypes.add(MediaType.APPLICATION_PDF);
		super.setSupportedMediaTypes(mediaTypes);
	}
}
