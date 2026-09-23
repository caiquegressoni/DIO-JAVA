package br.dio.arch.Strategy;

public class ComportamentoDefensivo implements Comportamento {
    @Override
    public void mover() {
        System.out.println("Mover defensivamente");
    }
}
