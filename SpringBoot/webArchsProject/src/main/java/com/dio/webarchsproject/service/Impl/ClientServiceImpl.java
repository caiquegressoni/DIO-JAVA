package com.dio.webarchsproject.service.Impl;

import com.dio.webarchsproject.model.Client;
import com.dio.webarchsproject.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public Iterable<Client> findAll() {
        return null;
    }

    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public void insert(Client client) {

    }

    @Override
    public void update(Long id, Client client) {

    }

    @Override
    public void delete(Long id) {

    }
}
