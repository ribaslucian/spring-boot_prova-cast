package br.com.baseapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BaseApplicationTests {

	@Test
	void contextLoads() {
	}

	
	// @Bean
	// public RedisTemplate<Long, Book> redisTemplate(RedisConnectionFactory connectionFactory) {
	// 	RedisTemplate<Long, Book> template = new RedisTemplate<>();
	// 	template.setConnectionFactory(connectionFactory);
	// 	// Add some specific configuration here. Key serializers, etc.
	// 	return template;
	// }
}
