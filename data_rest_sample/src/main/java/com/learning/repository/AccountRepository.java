package com.learning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.learning.model.Account;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByUsername(String username);
}
