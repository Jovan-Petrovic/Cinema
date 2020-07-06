package com.petrovic.jovan.cinema.config;

import com.petrovic.jovan.cinema.formatter.MovieDtoFormatter;
import com.petrovic.jovan.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

//konfigurisanje binova u web kontekstu za konkretni dispatcher
@Configuration
@Import(DatabaseConfiguration.class)
@ComponentScan(basePackages = {
    "com.petrovic.jovan.cinema"
}
)
@EnableJpaRepositories(basePackages = "com.petrovic.jovan.cinema.repository")
@EnableWebMvc
@EnableTransactionManagement
public class DemoWebContextConfig implements WebMvcConfigurer {

    private final MovieService movieService;

    @Autowired
    public DemoWebContextConfig(MovieService movieService) {
        this.movieService = movieService;
    }

    // configure Viewesolver
    @Bean
    public ViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setOrder(0);
        return tilesViewResolver;
    }

    @Bean
    public TilesConfigurer tilesCongigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(
                new String[]{"/WEB-INF/pages/tiles/tiles.xml"}
        );
        return tilesConfigurer;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("validation");
        return messageSource;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new MovieDtoFormatter(movieService));
    }

    
}
