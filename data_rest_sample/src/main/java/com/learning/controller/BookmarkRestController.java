package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.exception.BMFileNotFoundException;
import com.learning.model.BMFile;
import com.learning.repository.BMFileRepository;


@RepositoryRestController
@RequestMapping("/bookmarks")
public class BookmarkRestController {
	@Autowired
	private BMFileRepository bmFileRepository;

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
	
	/**
	 * Find a single bookmark file and transform it into a {@link ByteArrayResource}.
	 *
	 * @param bookmarkId
	 * @return ResponseEntity
	 */
	@GetMapping(value = "/{bookmarkId}/file",
			produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody ResponseEntity<Resource> getBookmarkFile(@PathVariable Long bookmarkId) {
		
		BMFile bmFile = this.bmFileRepository.findByBookmarkId(bookmarkId)
			.orElseThrow(() -> new BMFileNotFoundException(bookmarkId));
		String filename = bmFile.getBookmark().getDescription();

		ByteArrayResource resource = new ByteArrayResource(bmFile.getData());
		Long length = resource.contentLength();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(
			ContentDisposition.builder("inline").filename(filename).build()	
		);
		headers.setContentLength(length);
		headers.setContentType(MediaType.APPLICATION_PDF);
		
		return ResponseEntity.ok()
				.headers(headers)
				.body(resource);
	}
}
