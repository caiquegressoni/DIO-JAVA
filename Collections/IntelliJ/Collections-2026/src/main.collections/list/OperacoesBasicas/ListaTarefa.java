package main.collections.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> tarefaList;

    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    public void addTarefa(String description){
        tarefaList.add(new Tarefa(description));
    }

    public void removeTarefa(String description){
        List<Tarefa> tarefaRemover = new ArrayList<>();
        for (Tarefa tarefa : tarefaList){
            if(tarefa.getDescription().equalsIgnoreCase(description)){
                tarefaRemover.add(tarefa);
            }
            tarefaList.removeAll(tarefaRemover);
        }
    }

    public int obeterTotalTarefa(){
        return tarefaList.size();
    }

    public void obeterDescricaoTarefa(){
        System.out.println(tarefaList);
    }
}
