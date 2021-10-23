package com.api.bookie.repositories;

import com.api.bookie.models.LivroModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILivroRepository extends JpaRepository<LivroModel, Integer> {

}
