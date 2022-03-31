package com.sanitas.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
	//navegaciones estáticas
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/").setViewName("index");
	}
	//registro de los recursos estaticos (imagenes, videos, documentos,...)
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/*").addResourceLocations("/");
				/*registry.addResourceHandler("/*.gif").addResourceLocations("/imagenes");
				registry.addResourceHandler("/*.css").addResourceLocations("/estilos");*/
	}
}
