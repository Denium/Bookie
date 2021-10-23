package com.api.bookie.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
 
  private Integer id;
  private String nome;
  private String telefone;
  private String email;
}
