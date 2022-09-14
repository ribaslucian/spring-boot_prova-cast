package br.com.provacast;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.cloud.openfeign.EnableFeignClients;

import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
@EnableFeignClients
public class ProvaCastApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProvaCastApplication.class, args);
  }

  // Colocar em local adequado posteriormente.
  @Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

  // @Bean
  // MeterRegistryCustomizer<MeterRegistry> configurer(
  //     @Value("${spring.application.name}") String applicationName) {
  //     return (registry) -> registry.config().commonTags("application", applicationName);
  // }
}