package com.learning.processor;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

import com.learning.model.Bookmark;

public class BookmarkResourceProcessor implements ResourceProcessor<Resource<Bookmark>> {
	
	@Override
	public Resource<Bookmark> process(Resource<Bookmark> resource) {
		resource.add(new Link(resource.getId().getHref() + "/file", "file"));
		return resource;
	}

}
