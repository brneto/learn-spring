package com.learning.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.exception.BookmarkNotFoundException;
import com.learning.exception.UserNotFoundException;
import com.learning.model.Bookmark;
import com.learning.repository.AccountRepository;
import com.learning.repository.BookmarkRepository;

import resource.BookmarkResource;
import resource.PersonResource;


@RestController
@RequestMapping("/api")
public class BookmarkRestController {
	private final BookmarkRepository bookmarkRepository;
	private final AccountRepository accountRepository;
	
	@Autowired
	BookmarkRestController(BookmarkRepository bookmarkRepository, AccountRepository accountRepository) {
		this.bookmarkRepository = bookmarkRepository;
		this.accountRepository = accountRepository;
	}
	
	@GetMapping
	public ResourceSupport root() {
		ResourceSupport root = new ResourceSupport();

		root.add(accountRepository.findAll().stream()
			.map(account -> linkTo(methodOn(BookmarkRestController.class)
				.readBookmarks(account.getUsername()))
				.withRel(account.getUsername()))
			.collect(Collectors.toList()));

		return root;
	}
	
	@GetMapping("/people")
	public ResourceSupport readPerson() {
		return new PersonResource();
	}
	
	@GetMapping("/{userId}/bookmarks")
	public Resources<BookmarkResource> readBookmarks(@PathVariable String userId) {
		this.validateUser(userId);

		Resources<BookmarkResource> resources = new Resources<>(bookmarkRepository
				.findByAccountUsername(userId).stream()
				.map(BookmarkResource::new)
				.collect(Collectors.toList()));
		
		resources.add(linkTo(methodOn(this.getClass()).readBookmarks(userId)).withSelfRel());
		
		return resources;
	}
	
	@PostMapping("/{userId}/bookmarks")
	public ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input) {

		this.validateUser(userId);

		return accountRepository.findByUsername(userId)
			.map(account -> ResponseEntity
				.created(
					URI.create(
						new BookmarkResource(
							bookmarkRepository.save(Bookmark.from(account, input)))
						.getLink("self").getHref()))
				.build())
			.orElse(ResponseEntity.noContent().build());
	}
	
	/**
	 * Find a single bookmark and transform it into a {@link BookmarkResource}.
	 *
	 * @param userId
	 * @param bookmarkId
	 * @return
	 */
	@GetMapping("/{userId}/bookmarks/{bookmarkId}")
	public BookmarkResource readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
		this.validateUser(userId);

		return this.bookmarkRepository.findById(bookmarkId)
			.map(BookmarkResource::new)
			.orElseThrow(() -> new BookmarkNotFoundException(bookmarkId));
	}

	/**
	 * Verify the {@literal userId} exists.
	 *
	 * @param userId
	 */
	private void validateUser(String userId) {
		this.accountRepository
			.findByUsername(userId)
			.orElseThrow(() -> new UserNotFoundException(userId));
	}
}
