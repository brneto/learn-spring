package com.learning.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.learning.model.BMFile;

@RepositoryRestResource(exported=false)
public interface BMFileRepository extends PagingAndSortingRepository<BMFile, Long> {

}
