
package com.team5solution.Configuration.Web;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;


@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    private static final Charset UTF8 = StandardCharsets.UTF_8;

    // Cấu hình UTF-8 cho các trang.
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", UTF8)));
        converters.add(stringConverter);

        // Add other converters ...
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.stream().filter((converter) -> (converter instanceof org.springframework.http.converter.json.MappingJackson2HttpMessageConverter)).map((converter) -> ((MappingJackson2HttpMessageConverter) converter).getObjectMapper()).forEachOrdered((mapper) -> {
            mapper.registerModule(new Hibernate4Module());
            // replace Hibernate4Module() with the proper class for your hibernate version.
        });
    }

}
