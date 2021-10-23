package com.api.bookie.dtos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroAtualizarDTO {
  @Range(min = 1, message = "Id não pode ser menor quem 1")
  @NotNull(message = "o Id não pode ser nulo")
  private Integer id;
  private String nome;
  private Double preco;
  private String sinopse;
  private String ano;
}
