package br.com.provacast.services;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.provacast.domains.Conta;
import br.com.provacast.repositories.ContasRepository;

@Service
public class ContasService {

  @Autowired
  private ContasRepository contasRepository;

  public List<Conta> listAll() {
    return contasRepository.findAll();
  }

  public Page<Conta> paginate(Pageable pageable) {
    return contasRepository.findAll(pageable);
  }

  @Transactional
  public Conta create(Conta conta) {
    return contasRepository.save(conta);
  }

  public void deleteById(UUID id) {
    contasRepository.deleteById(id);
  }

}
