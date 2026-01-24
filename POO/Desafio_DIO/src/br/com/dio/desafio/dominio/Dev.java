package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String name;
    private Set<Conteudo> conteudoInscritos = new LinkedHashSet<>(); //Salva na ordem em que forem colocados
    private Set<Conteudo> conteudoConcluidos = new LinkedHashSet<>();

    public void increverBootCamp(BootCamp bootCamp) {
        this.conteudoInscritos.addAll(bootCamp.getConteudos()); //Adiciona todos os conteudos ao bootCamp
        bootCamp.getDevsInscritos().add(this); //Adiciona um Dev ao bootCamp
    }

    public void progredir(){
        Optional<Conteudo> conteudoOptional = this.conteudoInscritos.stream().findFirst();

        if(conteudoOptional.isPresent()){
            this.conteudoConcluidos.add(conteudoOptional.get());
            this.conteudoInscritos.remove(conteudoOptional.get());
        } else{
            System.err.println("Você não está matriculado em nenhum curso/mentoria");
        }
    }

    public double calcularTotalXp(){
        return this.conteudoConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Conteudo> getConteudoInscritos() {
        return conteudoInscritos;
    }

    public void setConteudoInscritos(Set<Conteudo> conteudoInscritos) {
        this.conteudoInscritos = conteudoInscritos;
    }

    public Set<Conteudo> getConteudoConcluidos() {
        return conteudoConcluidos;
    }

    public void setConteudoConcluidos(Set<Conteudo> conteudoConcluidos) {
        this.conteudoConcluidos = conteudoConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name) && Objects.equals(conteudoInscritos, dev.conteudoInscritos) && Objects.equals(conteudoConcluidos, dev.conteudoConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, conteudoInscritos, conteudoConcluidos);
    }
}
