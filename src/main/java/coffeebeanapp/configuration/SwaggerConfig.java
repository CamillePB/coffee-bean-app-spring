package coffeebeanapp.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.responses.ApiResponse;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI springCoffeebeanappOpenAPI() {
        return new OpenAPI()
        		.info(new Info()
        				.title("Projeto Coffee Bean App")
        				 .description("Projeto Coffee Bean App - Camille Bueno")
        				 .version("v0.0.1")
        				 .license(new License()
        						 .name("Camille Pedro Bueno")
        						 .url("https://www.linkedin.com/in/camillepbueno/"))
        						 .contact(new Contact()
        								 .name("Camille Pedro Bueno")
        								 .url("https://github.com/CamillePB")
        								 .email("camille.pedro.bueno@hotmail.com")))
        		.externalDocs(new ExternalDocumentation()
        				.description("Github")
        				.url("https://github.com/CamillePB/coffee-bean-app-spring"));     				
    }
    
    @Bean
    OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
    	
    	return openApi -> {
    		openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations()
    				.forEach(operation -> {
    					ApiResponses apiResponses = operation.getResponses();
    					
    					apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
    					apiResponses.addApiResponse("201", createApiResponse("Objeto Peristido!"));
    					apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
    					apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
    					apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
    					apiResponses.addApiResponse("403", createApiResponse("Acesso Proibido!"));
    					apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
    					apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));
    				}));
    	};
    	
    }
    
	private ApiResponse createApiResponse(String message) {
		// TODO Auto-generated method stub
		return new ApiResponse().description(message);
	}  
    
}
