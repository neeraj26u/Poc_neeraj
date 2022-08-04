package com.poc.resful.jersey.interceptor.filters;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import com.poc.resful.jersey.dao.UserDao;
import com.poc.resful.jersey.entities.User;
import com.poc.resful.jersey.model.AuthenticatedUserDetails;
import com.poc.resful.jersey.model.Authority;
import com.poc.resful.jersey.model.BasedSecurityContext;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.ext.Provider;



@Provider
public class CacheControllFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {		
		responseContext.getHeaders().add("Cache-Control", "no-cache");	
	}

}