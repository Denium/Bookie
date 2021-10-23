package com.api.bookie.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.api.bookie.dtos.LivroAtualizarDTO;
import com.api.bookie.dtos.LivroDTO;
import com.api.bookie.dtos.LivroSalvarDTO;
import com.api.bookie.models.LivroModel;
import com.api.bookie.repositories.ILivroRepository;

import org.springframework.beans.BeanUtils;
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
public class LivroController extends BaseController {

  private final ILivroRepository _repository;

  public LivroController(ILivroRepository repository) {
    this._repository = repository;
  }

  @PostMapping("/salvar")
  public int Salvar(@RequestBody @Valid LivroSalvarDTO dto) {
    LivroModel _model = new LivroModel();
    BeanUtils.copyProperties(dto, _model);
    return _repository.save(_model).getId();
  }

  @GetMapping("/buscar-tudo")
  public List<LivroDTO> BuscarTudo() {
    List<LivroDTO> dtos = new ArrayList<LivroDTO>();
    var livros = _repository.findAll();
    for (LivroModel l : livros) {
      LivroDTO dto = new LivroDTO();
      BeanUtils.copyProperties(l, dto);
      dtos.add(dto);
    }
    return dtos;
  }

  @PutMapping("/atualizar")
  public int Atualizar(@RequestBody @Valid LivroAtualizarDTO dto) {
    LivroModel _model = new LivroModel();
    BeanUtils.copyProperties(dto, _model);
    return _repository.save(_model).getId();
  }

  @GetMapping("/buscar-por-id/{id}")
  public LivroDTO BuscarPorId(@PathVariable Integer id) {
    var livroModel = _repository.findById(id).get();
    var livroDto = new LivroDTO();
    BeanUtils.copyProperties(livroModel, livroDto);
    return livroDto;
  }

  @DeleteMapping("/excluir/{id}")
  public void Excluir(@PathVariable Integer id) {
    _repository.deleteById(id);
  }
}
