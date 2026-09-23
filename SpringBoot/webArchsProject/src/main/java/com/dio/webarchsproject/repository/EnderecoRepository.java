package com.dio.webarchsproject.repository;

import com.dio.webarchsproject.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
