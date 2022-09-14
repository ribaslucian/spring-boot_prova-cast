// https://github.com/devdojobr/springboot2-essentials/tree/video34/src/test/java/academy/devdojo/springboot2
package br.com.baseapp.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.baseapp.domains.User;
import br.com.baseapp.repositories.UsersRepository;

// @DataJpaTest
@SpringBootTest
@DisplayName("Tests for User Repository")
class UserRepositoryTest {
    @Autowired
    private UsersRepository userRepository;

    @Test
    @DisplayName("Save creates user when success")
    void savePersistUserWhenSuccessful() { 
        User userToBeSaved = createUser();
        User savedUser = userRepository.save(userToBeSaved);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isNotNull();
        Assertions.assertThat(savedUser.getName()).isEqualTo(userToBeSaved.getName());
    }

    // @Test
    // void testFindBySimilarityName() {

    // }


    private User createUser() {
       return User.builder()
        .name("user.test")
        .fullName("Full Test Name User")
        .password("123")
        .hierarchy("holder")
        .build();
    }

//     @Test
//     @DisplayName("Save throw ConstraintViolationException when name is empty")
//     void save_ThrowsConstraintViolationException_WhenNameIsEmpty(){
//         Anime anime = new Anime();
// //        Assertions.assertThatThrownBy(() -> this.animeRepository.save(anime))
// //                .isInstanceOf(ConstraintViolationException.class);

//         Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
//                 .isThrownBy(() -> this.animeRepository.save(anime))
//                 .withMessageContaining("The anime name cannot be empty");
//     }
}
