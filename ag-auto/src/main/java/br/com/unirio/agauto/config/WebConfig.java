package br.com.unirio.agauto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	
	@Autowired
	private StartupListener startupListener;

	@Bean
	public PathMatcher pathMatcher() {
		return new CaseInsensitivePathMatcher();
	}

	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		startupListener.createBasicData();

		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		handlerMapping.setOrder(0);
		handlerMapping.setInterceptors(getInterceptors());
		handlerMapping.setPathMatcher(pathMatcher());
		return handlerMapping;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}
}
