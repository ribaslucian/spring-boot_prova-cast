package br.com.baseapp.dtos.users;

import lombok.Data;

@Data
public class UserUpdateDto {
    
    // @NotEmpty(message = "É obrigatório informar um nome de usuário.")
    private String fullName;
    
    // @NotEmpty(message = "É obrigatório informar um nome de usuário.")
    private String name;
    
    // @NotEmpty(message = "É obrigatório informar um nome.")
    private String password;
    
    // @NotEmpty(message = "É obrigatório informar uma hierarquia.")
    private String hierarchy;
}
