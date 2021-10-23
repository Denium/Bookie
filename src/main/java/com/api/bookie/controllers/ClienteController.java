package com.api.bookie.controllers;

import java.util.List;

import com.api.bookie.models.ClienteModel;
import com.api.bookie.repositories.IClienteRepository;

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
public class ClienteController {

  private final IClienteRepository _repository;

  public ClienteController(IClienteRepository repository) {
    this._repository = repository;
  }

  @GetMapping("/buscar-tudo")
  public List<ClienteModel> BuscarTudo() {
    return _repository.findAll();
  }

  @GetMapping("/buscar-por-id/{id}")
  public ClienteModel Buscar(@PathVariable Integer id) {
    return _repository.findById(id).get();
  }

  @PostMapping("/salvar")
  public Integer Salvar(@RequestBody ClienteModel model) {
    ClienteModel _model = _repository.save(model);
    return _model.getId();
  }

  @PutMapping("/atualizar")
  public Integer Atualizar(@RequestBody ClienteModel model) {
    ClienteModel _model = _repository.save(model);
    return _model.getId();
  }

  @DeleteMapping("/excluir/{id}")
  public void Excluir(@PathVariable Integer id) {
    _repository.deleteById(id);
  }
}
