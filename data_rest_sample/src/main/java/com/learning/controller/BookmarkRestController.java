package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.exception.BookmarkNotFoundException;
import com.learning.repository.BMFileRepository;
import com.learning.repository.BookmarkRepository;


@RepositoryRestController
@RequestMapping("/api")
public class BookmarkRestController {
	private final BookmarkRepository bookmarkRepository;
	private final BMFileRepository bmfileRepository;
	
	@Autowired
	BookmarkRestController(BookmarkRepository bookmarkRepository, BMFileRepository bmfileRepository) {
		this.bookmarkRepository = bookmarkRepository;
		this.bmfileRepository = bmfileRepository;
	}
//	
//	@GetMapping("/{userId}/bookmarks")
//	public @ResponseBody ResponseEntity<Resources<Bookmark>> readBookmarks(@PathVariable String userId) {
//		this.validateUser(userId);
//
//		Resources<Resource<Bookmark>> resources = new Resources<>(bookmarkRepository
//				.findByAccountUsername(userId).stream()
//				.map(Resource::new).collect(Collectors.toList()));
//		
//		resources.add(linkTo(methodOn(this.getClass()).readBookmarks(userId)).withSelfRel());
//		
//		return resources;
//	}
//	
//	@PostMapping("/{userId}/bookmarks")
//	public ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input) {
//
//		this.validateUser(userId);
//
//		return accountRepository.findByUsername(userId)
//			.map(account -> ResponseEntity
//				.created(
//					URI.create(
//						new BookmarkResource(
//							bookmarkRepository.save(Bookmark.from(account, input)))
//						.getLink("self").getHref()))
//				.build())
//			.orElse(ResponseEntity.noContent().build());
//	}
//	
	/**
	 * Find a single bookmark and transform it into a {@link BookmarkResource}.
	 *
	 * @param userId
	 * @param bookmarkId
	 * @return
	 */
	@GetMapping("/bookmarks/{bookmarkId}/file")
	public @ResponseBody ResponseEntity<Resource> readBookmark(@PathVariable Long bookmarkId) {
		this.validateBookmark(bookmarkId);

		return this.bookmarkRepository.findById(bookmarkId)
			.map(BMFileRepository::new)
			.orElseThrow(() -> new BookmarkNotFoundException(bookmarkId));
	}

	/**
	 * Verify the {@literal userId} exists.
	 *
	 * @param userId
	 */
	private void validateBookmark(Long bookmarkId) {
		this.bookmarkRepository
			.findById(bookmarkId)
			.orElseThrow(() -> new BookmarkNotFoundException(bookmarkId));
	}
	
//	/**
//	 * Verify the {@literal userId} exists.
//	 *
//	 * @param userId
//	 */
//	private void validateUser(String userId) {
//		this.accountRepository
//			.findByUsername(userId)
//			.orElseThrow(() -> new UserNotFoundException(userId));
//	}
}
