package br.dio.arch.Strategy;

public class ComportamentoNormal implements Comportamento {
    @Override
    public void mover() {
        System.out.println("Mover executado");
    }
}
