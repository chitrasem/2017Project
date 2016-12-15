package com.chitra.school.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.chitra.school")
public class MainConfig extends WebMvcConfigurerAdapter {

	@Autowired
	RoleToUserProfileConverter roleToUserProfileConverter;

	@Bean
	public ResourceBundleViewResolver viewResolver1() {
		ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
		viewResolver.setOrder(1);
		viewResolver.setBasename("views");
		
		return viewResolver;	
		

	}

	@Bean
	public ViewResolver viewResolver2() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setOrder(2);
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/*
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript
	 * etc...
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");		
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource bundle = new ResourceBundleMessageSource();
		bundle.setBasename("messages");

		return bundle;
	}
	
	 /* Here we register the Hibernate4Module into an ObjectMapper, then set this custom-configured ObjectMapper
     * to the MessageConverter and return it to be added to the HttpMessageConverters of our application*/
/*    public MappingJackson2HttpMessageConverter jacksonMessageConverter(){
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

        ObjectMapper mapper = new ObjectMapper();
        //Registering Hibernate4Module to support lazy objects
        mapper.registerModule(new Hibernate4Module() );

        messageConverter.setObjectMapper(mapper);
        return messageConverter;

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //Here we add our custom-configured HttpMessageConverter
        converters.add(jacksonMessageConverter());
        super.configureMessageConverters(converters);
    }*/
	

	/**
	 * Configure Converter to be used. In our example, we need a converter to
	 * convert string values[Roles] to UserProfiles in newUser.jsp
	 */

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(roleToUserProfileConverter);
	}
}