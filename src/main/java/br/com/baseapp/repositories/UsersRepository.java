package br.com.baseapp.repositories;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.baseapp.domains.User;

// @Repository("UsersRepository")
// @ComponentScan(basePackages = "br.com.baseapp.repositories")
public interface UsersRepository extends JpaRepository<User, UUID> {

    // @Query("SELECT u FROM User u WHERE u.id > :id")
    // public List<User> findAllMoreThan(@Param("id") Long id);

    // public List<User> findByIdGreaterThan(UUID id);

    @Transactional
    void deleteById(UUID id);

    @Query(value = "SELECT * FROM Users u WHERE u.name ~* :name", nativeQuery = true)
    public List<User> findBySimilarityName(@Param("name") String name);
}
