package com.petrovic.jovan.cinema.config;

import com.petrovic.jovan.cinema.formatter.ActorDtoFormatter;
import com.petrovic.jovan.cinema.formatter.DirectorDtoFormatter;
import com.petrovic.jovan.cinema.formatter.MovieDtoFormatter;
import com.petrovic.jovan.cinema.service.ActorService;
import com.petrovic.jovan.cinema.service.DirectorService;
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
    private final DirectorService directorService;
    private final ActorService actorService;

    @Autowired
    public DemoWebContextConfig(MovieService movieService, DirectorService directorService, ActorService actorService) {
        this.movieService = movieService;
        this.directorService = directorService;
        this.actorService = actorService;
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
        messageSource.setBasenames("validationMovie", "validationProjection");
        return messageSource;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new MovieDtoFormatter(movieService));
        registry.addFormatter(new DirectorDtoFormatter(directorService));
        registry.addFormatter(new ActorDtoFormatter(actorService));
    }

    
}
