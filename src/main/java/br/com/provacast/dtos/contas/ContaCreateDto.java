package br.com.provacast.dtos.contas;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ContaCreateDto {
    
    @NotEmpty(message = "É obrigatório informar um nome para conta.")
    @Schema(example = "Conta de Pagamentos Escolares", description = "Nome da conta a ser criada.")
    private String nome;
    
    private String descricao;
}
