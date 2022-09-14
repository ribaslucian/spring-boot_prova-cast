// https://github.com/devdojobr/springboot2-essentials/blob/video31/src/test/java/academy/devdojo/springboot2/repository/AnimeRepositoryTest.java
package br.com.baseapp.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.baseapp.domains.User;

@SpringBootTest
class UsersServiceTest {

    @Autowired
    private UsersService userService;

    @Test
    void testCreate() {
        User userToBeSaved = createUser();
        User savedUser = userService.create(userToBeSaved);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isNotNull();
        Assertions.assertThat(savedUser.getName()).isEqualTo(userToBeSaved.getName());
    }

    @Test
    void testDeleteById() {

    }

    @Test
    void testListAll() {

    }

    private User createUser() {
       return User.builder()
        .fullName("Full Test Name User")
        .name("usertest")
        .password("123")
        .hierarchy("holder")
        .build();
    }

}
