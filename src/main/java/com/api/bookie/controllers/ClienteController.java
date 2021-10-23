package com.api.bookie.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.api.bookie.dtos.ClienteAtualizarDTO;
import com.api.bookie.dtos.ClienteDTO;
import com.api.bookie.dtos.ClienteSalvarDTO;
import com.api.bookie.models.ClienteModel;
import com.api.bookie.repositories.IClienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends BaseController {

  private final IClienteRepository _repository;

  public ClienteController(IClienteRepository repository) {
    this._repository = repository;
  }

  @GetMapping("/buscar-tudo")
  public List<ClienteDTO> BuscarTudo() {
    var clientes = _repository.findAll();
    List<ClienteDTO> clienteDTOs = new ArrayList<ClienteDTO>();
    for (ClienteModel clienteModel : clientes) {
      ClienteDTO dto = new ClienteDTO();
      BeanUtils.copyProperties(clienteModel, dto);
      clienteDTOs.add(dto);
    }
    return clienteDTOs;
  }

  @GetMapping("/buscar-por-id/{id}")
  public ClienteDTO Buscar(@PathVariable Integer id) {
    var cliente = _repository.findById(id).get();
    var clienteDto = new ClienteDTO();
    BeanUtils.copyProperties(cliente, clienteDto);
    return clienteDto;
  }

  @PostMapping("/salvar")
  public Integer Salvar(@RequestBody @Valid ClienteSalvarDTO dto) {
    var model = new ClienteModel();
    BeanUtils.copyProperties(dto, model);
    var _model = _repository.save(model);
    return _model.getId();
  }

  @PutMapping("/atualizar")
  public Integer Atualizar(@RequestBody @Valid ClienteAtualizarDTO dto) {
    var model = new ClienteModel();
    BeanUtils.copyProperties(dto, model);
    var _model = _repository.save(model);
    return _model.getId();
  }

  @DeleteMapping("/excluir/{id}")
  public void Excluir(@PathVariable Integer id) {
    _repository.deleteById(id);
  }
}
