package com.example.demo.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SwaggerConfig {
   @Bean
   public OpenAPI awesomeAPI() {
        
        return new OpenAPI()
                .info(new Info().title("Student API")
                        .description("Student API Description")
                        .version("1.0")
                        .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Revanth, revanth@gmail.com")
                        .url("http://localhost:8033/swagger-ui.html"));
   }
    
}
