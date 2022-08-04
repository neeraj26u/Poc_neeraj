package com.poc.resful.jersey.interceptor;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.resful.jersey.entities.User;
import com.poc.resful.jersey.namebinder.EmptyUserValidator;
import com.poc.resful.jersey.namebinder.PasswordValidator;

import jakarta.annotation.Priority;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;

@Provider
@Priority(value = 1)
public class UserEmptyInterceptor implements ReaderInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {		
		
		 InputStream is = context.getInputStream();
	        String body = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
	        ObjectMapper mapper = new ObjectMapper();
	        try {
	            User user = mapper.readValue(body, User.class);
	            if( (user.getName() == null ||user.getName().isEmpty()) 
	            		  || (user.getRole() == null || user.getRole().isEmpty()) 
	            		  || (user.getPassword() == null || user.getPassword().isEmpty()) || (user.getUserId() == null)  ) {
	            	  
	            	    throw new WebApplicationException(Response.ok().entity("user property should not be blank").build());
	            }
	        } catch (JsonGenerationException | JsonMappingException e) {
	           
	        }
	        InputStream in = new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8));

	        context.setInputStream(in);
	        return context.proceed();
	}
}