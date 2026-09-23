package br.dio.arch.Strategy;

public class ComportamentoAgressivo implements Comportamento {
    @Override
    public void mover() {
        System.out.println("Mover Agressivo");
    }
}
