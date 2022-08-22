package com.poc.resful.jersey.interceptor.filters;

import java.io.IOException;

import com.poc.resful.jersey.entities.User;
import com.poc.resful.jersey.namebinder.PasswordMaskBinder;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;



@Provider
@PasswordMaskBinder
public class PasswordMakerFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {	
		User user = (User) responseContext.getEntity();
		String mask = user.getPassword().replaceAll("\\w(?=\\w{0,})|\\W(?=\\W{0,})", "*");
		user.setPassword(mask);
		responseContext.setEntity(user);
		responseContext.getHeaders().add("Cache-Control", "no-cache");	
	}

}