package com.poc.resful.jersey;



import com.poc.resful.jersey.entities.User;
import com.poc.resful.jersey.namebinder.PasswordMaskBinder;
import com.poc.resful.jersey.namebinder.UniqueUserId;
import com.poc.resful.jersey.services.UserService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class UserResource {
	
	private UserService userService = new UserService();
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	@PasswordMaskBinder
	@RolesAllowed({"ADMIN"})
	public Response addUser( @Valid @UniqueUserId User user) {
		userService.addUser(user);
		return Response.status(Status.CREATED).entity(user).build();
	}
	
	
	
}
