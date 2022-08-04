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
import com.poc.resful.jersey.entities.Item;
import com.poc.resful.jersey.entities.User;
import com.poc.resful.jersey.namebinder.EmptyUserValidator;
import com.poc.resful.jersey.namebinder.IteamIdAndNameBinder;
import com.poc.resful.jersey.namebinder.ItemDiscriptionBinder;
import com.poc.resful.jersey.namebinder.PasswordValidator;

import jakarta.annotation.Priority;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;

@Provider
@Priority(value = 3)
@ItemDiscriptionBinder
public class ItemDiscriptionInterceptor implements ReaderInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {		
		
		 InputStream is = context.getInputStream();
	        String body = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
	        ObjectMapper mapper = new ObjectMapper();
	        
	        try {
	            Item item = mapper.readValue(body, Item.class);
	            if( item.getDescription() != null  ||  !item.getDescription().isEmpty() ) {
	            	  
	            	   if(item.getDescription().length() > 50) {
	            		   String s =  item.getDescription().substring(0, 50);
	            		   item.setDescription(s);
	            		   body = mapper.writeValueAsString(item);
	            	   }
	            }
	        } catch (JsonGenerationException | JsonMappingException e) {
	           
	        }
	        
	        InputStream in = new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8));

	        context.setInputStream(in);
	        return context.proceed();
	}
}