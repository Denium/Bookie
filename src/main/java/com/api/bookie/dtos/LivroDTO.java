package com.api.bookie.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

  private Integer id;
  private String nome;
  private Double preco;
  private String sinopse;
  private String ano;
}
