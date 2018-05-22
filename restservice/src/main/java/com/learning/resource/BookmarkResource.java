package com.learning.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.learning.controller.BookmarkRestController;
import com.learning.model.Bookmark;

public class BookmarkResource extends ResourceSupport {
	
	private final Bookmark bookmark;
	
	public BookmarkResource(Bookmark bookmark) {

		this.bookmark = bookmark;

		String username = bookmark.getAccount().getUsername();

		this.add(new Link(bookmark.getUri(), "bookmark-uri"));
		this.add(linkTo(BookmarkRestController.class, username).withRel("bookmarks"));
		this.add(linkTo(methodOn(BookmarkRestController.class, username).readBookmark(username, bookmark.getId())).withSelfRel());
	}

	public Bookmark getBookmark() {
		return bookmark;
	}

}
