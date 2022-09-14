package br.com.provacast.controllers.api.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.server.ResponseStatusException;

import br.com.provacast.components.Utils;
import br.com.provacast.domains.Conta;
import br.com.provacast.dtos.contas.ContaCreateDto;
import br.com.provacast.dtos.contas.ContaUpdateDto;
import br.com.provacast.exceptions.BadRequestException;
import br.com.provacast.repositories.ContasRepository;
import br.com.provacast.services.ContasService;

@RestController
@RequestMapping("/api/v1/contas")
@AllArgsConstructor
public class ContasController {

  private ContasRepository contasRepository;
  private ContasService contasService;
  private ModelMapper modelMapper;

  @GetMapping("/")
  public ResponseEntity<List<Conta>> list() {
    return ResponseEntity.ok(contasService.listAll());
  }

  @GetMapping("/paginate")
  @Operation(summary = "List all contas paginated", description = "The default size is 5, use the parameter size to change the default value", tags = {"contas"})
  public ResponseEntity<Page<Conta>> paginate(@Parameter(hidden = true) Pageable pageable) {
    return ResponseEntity.ok(contasService.paginate(pageable));
  }

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  @PreAuthorize("hasRole('ADMIN')")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Successful Operation"),
    @ApiResponse(responseCode = "400", description = "When Anime Does Not Exist in The Database")
})
  public Conta create(@RequestBody @Valid ContaCreateDto contaDto) {
    Conta conta = modelMapper.map(contaDto, Conta.class);
    return contasService.create(conta);
  }

  @GetMapping("/{id}")
  public Conta findById(@PathVariable("id") UUID id) {
    return contasRepository
      .findById(id)
      .orElseThrow(() -> new BadRequestException("Entity not fount."));
  }

  @GetMapping("/findBySimilarityNome/{nome}")
  public List<Conta> findBySimilarityNome(@PathVariable("nome") String nome) {
    return contasRepository.findBySimilarityNome(nome);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @ResponseBody
  public Conta update(@RequestBody @Valid ContaUpdateDto contaUpdateDto, @PathVariable("id") UUID id) {
    Conta localConta = contasRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Entity ID not fount."
          )
      );

    Conta updatedConta = modelMapper.map(contaUpdateDto, Conta.class);

    Utils.copyNonNullProperties(updatedConta, localConta);
    return contasRepository.save(localConta);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") UUID id) {
    contasService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
