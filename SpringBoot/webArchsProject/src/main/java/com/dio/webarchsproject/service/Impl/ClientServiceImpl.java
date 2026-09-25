package com.dio.webarchsproject.service.Impl;

import com.dio.webarchsproject.model.Client;
import com.dio.webarchsproject.model.Endereco;
import com.dio.webarchsproject.repository.ClientRepository;
import com.dio.webarchsproject.repository.EnderecoRepository;
import com.dio.webarchsproject.service.ClientService;
import com.dio.webarchsproject.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        //TODO: metodo de verificação para caso não haja cliente
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        saveClientWithCep(client);
    }



    @Override
    public void update(Long id, Client client) {
        Optional<Client> verifyClient = clientRepository.findById(id);
        if(verifyClient.isPresent()) {
            saveClientWithCep(client);
        }else{
            System.out.println("Erro ao tentar atualizar o cliente");
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);

    }

    private void saveClientWithCep(Client client) {
        String cep = client.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco newEndereco = viaCepService.consultaCep(cep);
            enderecoRepository.save(newEndereco);
            return newEndereco;
        });
        client.setEndereco(endereco);
        clientRepository.save(client);
    }
}
