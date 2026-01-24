package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class BootCamp {
    private String name;
    private String descricao;
    private final LocalDate dataInicio =  LocalDate.now();
    private final LocalDate dataFim =  dataInicio.plusDays(45);

    private Set<Dev> devsInscritos = new HashSet<Dev>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BootCamp bootCamp = (BootCamp) o;
        return Objects.equals(name, bootCamp.name) && Objects.equals(descricao, bootCamp.descricao) && Objects.equals(dataInicio, bootCamp.dataInicio) && Objects.equals(dataFim, bootCamp.dataFim) && Objects.equals(devsInscritos, bootCamp.devsInscritos) && Objects.equals(conteudos, bootCamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, descricao, dataInicio, dataFim, devsInscritos, conteudos);
    }
}
