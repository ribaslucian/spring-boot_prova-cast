package br.com.provacast.repositories;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.provacast.domains.Conta;

public interface ContasRepository extends JpaRepository<Conta, UUID> {

    @Transactional
    void deleteById(UUID id);

    @Query(value = "SELECT * FROM Contas u WHERE u.nome ~* :nome", nativeQuery = true)
    public List<Conta> findBySimilarityNome(@Param("nome") String nome);
}
