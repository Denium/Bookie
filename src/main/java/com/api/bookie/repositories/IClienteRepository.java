package com.api.bookie.repositories;

import com.api.bookie.models.ClienteModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<ClienteModel, Integer> {

}
