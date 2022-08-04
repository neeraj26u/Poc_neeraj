package com.poc.resful.jersey.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.poc.resful.jersey.UserResource;
import com.poc.resful.jersey.exeptionmapper.AccessDeniedExceptionMapper;
import com.poc.resful.jersey.exeptionmapper.AuthenticationExceptionMapper;
import com.poc.resful.jersey.interceptor.filters.AuthenticationFilter;
import com.poc.resful.jersey.interceptor.filters.AuthorizationFilter;
import com.poc.resful.jersey.interceptor.filters.CacheControllFilter;


public class AppConfig extends ResourceConfig {

	public AppConfig() {
		register(UserResource.class);

        register(AuthenticationFilter.class);
        register(AuthorizationFilter.class);
        register(CacheControllFilter.class);
     
        register(AccessDeniedExceptionMapper.class);
        register(AuthenticationExceptionMapper.class);

	}
}