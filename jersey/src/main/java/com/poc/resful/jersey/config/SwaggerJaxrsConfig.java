package com.poc.resful.jersey.config;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.poc.resful.jersey.ItemResource;
import com.poc.resful.jersey.UserResource;

import jakarta.ws.rs.core.Application;

public class SwaggerJaxrsConfig extends Application {
	
	@Override
    public Set<Class<?>> getClasses() {
        return Stream.of(UserResource.class, ItemResource.class).collect(Collectors.toSet());
    }
 
}
