package appi_dia_festivo.appi_dia_festivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class AppiDiaFestivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppiDiaFestivoApplication.class, args);
	}
	// Para actualizar las politicas del cors
	@Bean
	public CorsFilter CorsFilter(){
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);	
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedMethod("*");//para permitir todos los metodos get y set
		config.addAllowedHeader("*"); // Todos los encabezados 

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);

	}


}
 