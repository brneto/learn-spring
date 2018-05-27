package com.learning.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.model.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
	Collection<Bookmark> findByAccountUsername(String username);
}
