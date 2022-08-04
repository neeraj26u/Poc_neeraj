package com.poc.resful.jersey;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.poc.resful.jersey.entities.User;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

class UserResourceTest extends JerseyTest {
	
	
	@Override
	 public Application configure() {
	  enable(TestProperties.LOG_TRAFFIC);
	  enable(TestProperties.DUMP_ENTITY);
	  return new ResourceConfig(UserResource.class);
	 }


	 
	 User user = new User(3l, "name", "role", "password");
	 
	 @Test
	 public void testCreate() {
	 
	  Response output = target("/myresource/create").request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
	  System.out.println(output.getStatus());
	  assertEquals("Should return status 201", 201, output.getStatus());
	 }


}
