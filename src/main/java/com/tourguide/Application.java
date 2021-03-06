package com.tourguide;

import com.tourguide.common.ro.MyTestSubRo;
import com.tourguide.controller.converters.StringToEntityConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by liutongbin on 2017/3/25.
 */

//@SpringBootApplication
////@EnableAutoConfiguration
////@ComponentScan(basePackages = "com.tourguide")

@Controller
@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = "com.tourguide.mapper")
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8081);
    }

    @Bean
    public StringToEntityConverter myTestSubRoConverter() {
        return new StringToEntityConverter(MyTestSubRo.class);
    }

//    @PostConstruct
//    public void initEditableValidation() {
//        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
//        if (initializer.getConversionService() != null) {
//            GenericConversionService genericConversionService = (GenericConversionService) initializer.getConversionService();
//            genericConversionService.addConverter(myTestSubRoConverter());
//        }
//    }
    //    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext context) {
//        return args -> {
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//            String[] beanNames = context.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println("beanName:" + beanName);
//            }
//        };
//    }

}
