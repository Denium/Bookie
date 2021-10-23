package com.api.bookie.models;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class ClienteModel {
  private Integer id;
  private String nome;
  private String telefone;
  private String email;
}
