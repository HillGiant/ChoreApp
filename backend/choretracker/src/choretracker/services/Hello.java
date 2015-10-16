package choretracker.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import choretracker.entities.Chore;
import choretracker.dataaccess.ChoreRepository;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
public class Hello {
	private ChoreRepository repository;
	public Hello()
	{
		repository = new ChoreRepository();
	}
	
  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces({
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_JSON
  })
  public List<Chore> getChores() {
	  return repository.GetChores().stream().map(Chore::FromChoreRecord).collect(Collectors.toList());
  }
} 