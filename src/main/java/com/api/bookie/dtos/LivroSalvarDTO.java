package com.api.bookie.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroSalvarDTO {
  @NotBlank(message = "Nome do livro é obrigatorio")
  private String nome;

  @NotNull(message = "O valor não pode ser nulo")
  private Double preco;

  private String sinopse;
  private String ano;
}
