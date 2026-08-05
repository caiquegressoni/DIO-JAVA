package dio.web_api.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    /*
    * Na versão 4.0 e 3.0 do springboot não é mais oferecido suporte para o springfox (antigo Swagger)
    * Hoje nas versões mais recentes do spring utilizamos o OpenApi, onde não é necessario fazer a classe de configuração.
    * Ficando exclusivamente para casos de personalização.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("API Documentation").description("API Documentation"));
    }
}
