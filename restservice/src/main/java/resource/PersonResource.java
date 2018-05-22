package resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import com.learning.controller.BookmarkRestController;

public class PersonResource extends ResourceSupport {
	String firstname;
  String lastname;
  
  public PersonResource() {
  	this.firstname = "Berchris";
  	this.lastname = "Requiao";
  	
  	this.add(linkTo(methodOn(BookmarkRestController.class).readPerson()).withSelfRel());
  }
  
  public String getFirtName() {
  	return this.firstname;
  }
  
  public String getLastName() {
  	return this.lastname;
  }
}
