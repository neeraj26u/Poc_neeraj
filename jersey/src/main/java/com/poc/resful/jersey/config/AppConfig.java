package com.poc.resful.jersey.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.poc.resful.jersey.ItemResource;
import com.poc.resful.jersey.UserResource;
import com.poc.resful.jersey.exeptionmapper.AccessDeniedExceptionMapper;
import com.poc.resful.jersey.exeptionmapper.AuthenticationExceptionMapper;
import com.poc.resful.jersey.interceptor.filters.ApiOriginFilter;
import com.poc.resful.jersey.interceptor.filters.AuthenticationFilter;
import com.poc.resful.jersey.interceptor.filters.AuthorizationFilter;
import com.poc.resful.jersey.interceptor.filters.CacheControllFilter;
import com.poc.resful.jersey.interceptor.filters.PasswordMakerFilter;



public class AppConfig extends ResourceConfig {

	public AppConfig() {
			
		packages("com.poc.resful.jersey");
		register(UserResource.class);
		register(ItemResource.class);
        register(AuthenticationFilter.class);
        register(AuthorizationFilter.class);
        register(CacheControllFilter.class);
        register(PasswordMakerFilter.class);
        register(AccessDeniedExceptionMapper.class);
        register(AuthenticationExceptionMapper.class);
        register(ApiOriginFilter.class);
        
	}
}