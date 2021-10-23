package com.api.bookie.dtos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteAtualizarDTO {
  @Range(min = 1, message = "Id não pode ser nulo.") 
  @NotNull(message = "Id não pode ser menor que 1.")
  private Integer id;
  private String nome;
  private String telefone;
  private String email;
}
