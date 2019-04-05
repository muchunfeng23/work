//package com.yl.work;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
//import org.thymeleaf.templateresolver.TemplateResolver;
//
//@Configuration
//public class Config {
////    @Bean
////    public InternalResourceViewResolver viewResolver(){
////        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
////        viewResolver.setPrefix("/WEB-INF/classes/views/");
////        viewResolver.setSuffix(".jsp");
////        viewResolver.setViewClass(Jst1View.class);
////        return viewResolver;
////    }
//
////    @Bean
////    public TemplateResolver templateResolver(){
////        TemplateResolver templateResolver = new ServletContextTemplateResolver();
////        templateResolver.setPrefix("/WEB-INF/templates");
////        templateResolver.setSuffix(".html");
////        templateResolver.setTemplateMode("HTML5");
////        return templateResolver;
////    }
////
////    @Bean
////    public SpringTemplateEngine templateEngine(){
////        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
////        templateEngine.setTemplateResolver(templateResolver());
////        return templateEngine;
////    }
////
////    @Bean
////    public ThymeleafViewResolver thymeleafViewResolver(){
////        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
////        thymeleafViewResolver.setTemplateEngine(templateEngine());
////        return thymeleafViewResolver;
////    }
//
//
//}
