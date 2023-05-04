package com.shivam.props;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

import java.util.HashMap;

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="training")
public class AppProperties {
	private Map<String,String> messages = new HashMap<>();
	
}
