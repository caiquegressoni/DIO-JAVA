package br.dio.arch.SubSistemaCEP;

public class CepApi {
    private static final CepApi instance = new CepApi();

    private CepApi() {
        super();
    }

    public static CepApi getInstance() {
        return instance;
    }

    public String recuperarCep(String cep) {
        return "Tocantins";
    }

    public String recuperarEstado(String cep) {
        return "SP";
    }
}
