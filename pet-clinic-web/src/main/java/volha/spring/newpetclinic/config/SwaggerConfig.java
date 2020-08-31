package volha.spring.newpetclinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/*
 *Created by olga on 12.08.2020
 */
@EnableSwagger2
@Import(SwaggerConfig.class)
public class SwaggerConfig { //extends WebMvcConfigurationSupport {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
//                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        Contact contact = new Contact("Volha", "http://localhost:8080", "olgakochanowa@gmail.com");
        return new ApiInfo("Pet Clinic", "Application for pet clinic",
                "1,0", "termsOfServiceUrl", contact,
                "license", "licenseUrl", new ArrayList());
    }
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resource");
//
//        registry.addResourceHandler("/webjars/*")
//                .addResourceLocations("classpath:/META-INF/resource/webjars");
//    }
}
