package com.learning;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.http.converter.HttpMessageConverter;

import com.learning.converter.PdfHttpMessageConverter;
import com.learning.model.Account;
import com.learning.model.Bookmark;
import com.learning.processor.BookmarkResourceProcessor;
import com.learning.repository.AccountRepository;
import com.learning.repository.BookmarkRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureHttpMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
				messageConverters.add(0, new PdfHttpMessageConverter());
			}
		};
	}

	@Bean
	public ResourceProcessor<Resource<Bookmark>> bookmarkResourceProcessor() {
		return new BookmarkResourceProcessor();
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository) {
		return evt -> Arrays.asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
				.forEach(a -> {
					Account account = accountRepository.save(new Account(a, "password"));
					bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/link1/" + a, "A description"));
					bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/link2/" + a, "A description"));
				});
	}

}
