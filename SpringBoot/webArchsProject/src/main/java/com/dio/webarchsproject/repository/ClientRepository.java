package com.dio.webarchsproject.repository;

import com.dio.webarchsproject.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ClientRepository extends CrudRepository<Client, Long> {
}
