package com.shivam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.shivam.binding.User;

@Configuration
public class RedisConfig {
	
	// Use to connect with redis server
	@Bean
	public JedisConnectionFactory getJedisConnection() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		
		return factory;
	}
	
	//Creating bean for redisTemplate
	@Bean
	@Primary
	public RedisTemplate<String, User> getRedisTemplate(JedisConnectionFactory factory){
		RedisTemplate<String, User> rt = new RedisTemplate<>();
		rt.setConnectionFactory(factory);
		return rt;
	}
}
