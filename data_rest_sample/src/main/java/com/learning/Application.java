package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;

import com.learning.model.Account;
import com.learning.model.Bookmark;
import com.learning.repository.AccountRepository;
import com.learning.repository.BookmarkRepository;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner init(AccountRepository accountRepository,
			BookmarkRepository bookmarkRepository) {
				return evt ->
					Arrays.asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
						.forEach(a -> {
							Account account = accountRepository.save(new Account(a, "password"));
							bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/link1/" + a, "A description"));
							bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/link2/" + a, "A description"));
						});
	}
	
	
	public @Bean ResourceProcessor<Resource<Bookmark>> bookmarkProcessor() {
		return new ResourceProcessor<Resource<Bookmark>>() {
			@Override
	    public Resource<Bookmark> process(Resource<Bookmark> resource) {
				resource.add(new Link("http://localhost:8080/people", "added-link"));
	      return resource;
	     }
	   };
	}
	
	public @Bean RepositoryRestConfigurer repositoryRestConfigurer() {
		return new RepositoryRestConfigurerAdapter() {
	    @Override
	    public void configureHttpMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
	    	ResourceHttpMessageConverter pdfHttpMessageConverter = new ResourceHttpMessageConverter();
	    	List<MediaType> mediaTypes = new ArrayList<>();
	    	
	    	mediaTypes.add(MediaType.APPLICATION_PDF);
	    	pdfHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
	    	
	    	messageConverters.add(0, pdfHttpMessageConverter);
	    }
		};
	}

}
