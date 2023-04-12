package br.edu.ifpb.dac.wandeilson.projeto2jpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class ProjetoJpaApplication implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(ProjetoJpaApplication.class, args);
	}
	@Override
	public void addCorsMappings(CorsRegistry corsRegistry){
		corsRegistry.addMapping("/**")
				.allowedMethods("GET", "POST","PUT", "DELETE", "OPTIONS", "PATCH");
	}
}
