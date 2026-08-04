package dio.web_api.doc;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contact(){
        return new Contact(
                "Name",
                "https://localhost:8080",
                "name@name.com"
        );
    }
    private ApiInfoBuilder informationApi(){
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Title - Rest API");
        apiInfoBuilder.description("Description - Rest API");
        apiInfoBuilder.version("Version - 1.0");
        apiInfoBuilder.termsOfServiceUrl("Terms-of-service URL");
        apiInfoBuilder.license("Lincense - TestRestApi");
        apiInfoBuilder.licenseUrl("https://localhost:8080");
        apiInfoBuilder.contact(contact());

        return apiInfoBuilder;
    }
}
