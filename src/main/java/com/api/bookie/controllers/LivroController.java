package com.api.bookie.controllers;

import java.util.List;

import com.api.bookie.models.LivroModel;
import com.api.bookie.repositories.ILivroRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/livro")
public class LivroController {

  private final ILivroRepository _repository;

  public LivroController(ILivroRepository repository) {
    this._repository = repository;
  }

  @PostMapping("/salvar")
  public int Salvar(@RequestBody LivroModel model) {
    LivroModel _model = _repository.save(model);
    return _model.getId();
  }

  @GetMapping("/buscar-tudo")
  public List<LivroModel> BuscarTudo() {
    return _repository.findAll();
  }

  @PutMapping("/atualizar")
  public int Atualizar(@RequestBody LivroModel model) {
    LivroModel _model = _repository.save(model);
    return _model.getId();
  }

  @GetMapping("/buscar-por-id/{id}")
  public LivroModel BuscarPorId(@PathVariable Integer id) {
    return _repository.findById(id).get();
  }

  @DeleteMapping("/excluir/{id}")
  public void Excluir(@PathVariable Integer id) {
    _repository.deleteById(id);
  }
}
