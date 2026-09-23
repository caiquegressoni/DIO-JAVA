package br.dio.arch.Facade;

import br.dio.arch.SubSistemaCEP.CepApi;
import br.dio.arch.SubSitemaCRM.CrmService;

public class Facade {
    public void migrarClient(String nome, String cep) {
        String cidade = CepApi.getInstance().recuperarCep(cep);
        String estado = CepApi.getInstance().recuperarCep(cep);

        CrmService.gravarCliente(nome, cep, estado, cidade);
    }
}
