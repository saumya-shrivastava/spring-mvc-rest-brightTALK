package com.brighttalk.realms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScans(value = { @ComponentScan("com.brighttalk.realms.controller") ,
		@ComponentScan("com.brighttalk.realms.exception") })
public class WebConfig extends WebMvcConfigurerAdapter{

	
}
