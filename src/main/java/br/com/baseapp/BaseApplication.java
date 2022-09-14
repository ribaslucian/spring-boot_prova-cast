package br.com.baseapp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
// @RestController
public class BaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(BaseApplication.class, args);
  }

  @Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

  @Bean
  MeterRegistryCustomizer<MeterRegistry> configurer(
      @Value("${spring.application.name}") String applicationName) {
      return (registry) -> registry.config().commonTags("application", applicationName);
  }

  // @GetMapping("/hello")
  // public String hello(
  //   @RequestParam(value = "name", defaultValue = "World") String name
  // ) {
  //   return String.format("Hello %s!", name);
  // }
}

// Versione o projeto no github.com e crie a estrutura de desenvolvimento e branches baseadas no gitflow;
// Crie uma chamada para o serviço http://viacep.com.br/ws/01001000/json/ utilizando Spring Cloud OpenFeign e disponibilize um endpoint para expor o resultado da chamada.