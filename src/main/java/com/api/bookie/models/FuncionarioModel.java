package com.api.bookie.models;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "funcionario")
public class FuncionarioModel {
  private Integer id;
  private String nome;
  private String email;
  private String senha;
}
