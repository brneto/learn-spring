package com.learning.repository;

import java.util.Collection;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.learning.model.Bookmark;

@RepositoryRestResource
public interface BookmarkRepository extends PagingAndSortingRepository<Bookmark, Long> {
	Collection<Bookmark> findByAccountUsername(String username);
}
