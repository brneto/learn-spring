package resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class PersonResource extends ResourceSupport {
	String firstname;
  String lastname;
  
  public PersonResource() {
  	this.firstname = "Berchris";
  	this.lastname = "Requiao";
  	
  	this.add(new Link("http://myhost/people"));
  }
  
  public String getFirtName() {
  	return this.firstname;
  }
  
  public String getLastName() {
  	return this.lastname;
  }
}
