package com.poc.resful.jersey.interceptor.filters;

import java.io.IOException;

import org.glassfish.jersey.servlet.ServletContainer;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;

public class SwaggerOriginFilter  implements Filter {
	  @Override
	  public void doFilter(ServletRequest request, ServletResponse response,
	      FilterChain chain) throws IOException, ServletException {
	    HttpServletResponse res = (HttpServletResponse) response;
	    res.addHeader("Access-Control-Allow-Origin", "*");
	    res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
	    res.addHeader("Access-Control-Allow-Headers", "Content-Type");
	    chain.doFilter(request, response);
	  }

	  
	}
	