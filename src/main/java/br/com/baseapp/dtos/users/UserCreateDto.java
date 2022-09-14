package br.com.baseapp.dtos.users;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserCreateDto {
    
    // @NotEmpty(message = "É obrigatório informar um ID.")
    // private UUID id;
    
    @NotEmpty(message = "É obrigatório informar um nome completo.")
    @Schema(example = "Lucian Rossoni Ribas", description = "Nome completo do usuário a ser criado.")
    private String fullName;
    
    @NotEmpty(message = "É obrigatório informar um nome de usuário.")
    private String name;
    
    @NotEmpty(message = "É obrigatório informar um nome.")
    private String password;
    
    @NotEmpty(message = "É obrigatório informar uma hierarquia.")
    private String hierarchy;
}
