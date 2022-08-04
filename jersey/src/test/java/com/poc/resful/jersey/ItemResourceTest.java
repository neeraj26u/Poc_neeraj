package com.poc.resful.jersey;

import static org.junit.Assert.assertEquals;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.jupiter.api.Test;

import com.poc.resful.jersey.entities.Item;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

class ItemResourceTest extends JerseyTest {
	
	
	@Override
	 public Application configure() {
	  enable(TestProperties.LOG_TRAFFIC);
	  enable(TestProperties.DUMP_ENTITY);
	  return new ResourceConfig(ItemResource.class);
	 }


	 
	 Item item = new Item("p12345", "Laptop", "Item type is laptop", 100d);
	 
	 @Test
	 public void testCreate() {
	 
	  Response output = target("/item-resource/create").request().post(Entity.entity(item, MediaType.APPLICATION_JSON));
	  System.out.println(output.getStatus());
	  assertEquals("Should return status 201", 201, output.getStatus());
	 }


}