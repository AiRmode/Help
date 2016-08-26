package com.provectus.prodobro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan({"com.provectus.prodobro.controller"})
//@ImportResource("classpath:/applicationContext-services.xml")
public class WebConfig extends WebMvcConfigurerAdapter {


/*
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
		List<MediaType> types = new ArrayList<>(1);
		types.add(MediaType.APPLICATION_JSON);
		jacksonConverter.setSupportedMediaTypes(types);
		converters.add(jacksonConverter);
	}
*/
}
