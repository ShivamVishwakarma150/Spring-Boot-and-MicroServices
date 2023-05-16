package com.shivam;


import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.*;
import reactor.core.publisher.Mono;

@Component
public class MyPreFilter implements GlobalFilter{
	
	Logger logger = LoggerFactory.getLogger(MyPreFilter.class);
	
	
	
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange,GatewayFilterChain chain){
		
		logger.info("filter() method executed.....");
		
		//Access request information
		ServerHttpRequest request = exchange.getRequest();
		
		HttpHeaders headers = request.getHeaders();
		
		Set<String> keySet = headers.keySet();
		
		keySet.forEach(key->{
			List<String> values = headers.get(key);
			System.out.println(key + "::" + values);
		});
		
		
		return chain.filter(exchange);
	}
	
}
