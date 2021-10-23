package com.api.bookie.models;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "livro")
public class LivroModel {
  private Integer id;
  private String nome;
  private Double preco;
  private String sinopse;
  private String ano;
}
