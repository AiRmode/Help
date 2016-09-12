package com.provectus.prodobro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan({"com.provectus.prodobro.controller"})
@ImportResource({"classpath:/applicationContext-services.xml",
        "classpath:/auth-context.xml"})
public class WebConfig extends WebMvcConfigurerAdapter {

}
