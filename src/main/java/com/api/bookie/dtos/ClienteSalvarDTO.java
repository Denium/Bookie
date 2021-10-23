package com.api.bookie.dtos;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSalvarDTO {

  @NotBlank(message = "Nome é obrigatório.")
  private String nome;

  @NotBlank(message = "Telefone é obrigatório.")
  private String telefone;

  @NotBlank(message = "Email é obrigatório.")
  private String email;
}
