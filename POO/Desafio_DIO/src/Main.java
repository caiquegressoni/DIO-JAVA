import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso();

        curso.setTitulo("Curso Java");
        curso.setDescricao("Curso Java");
        curso.setCargaHoraria(42);

        Mentoria mentoria = new Mentoria();

        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("Mentoria Java");
        mentoria.setData(LocalDate.now());

        /*System.out.println(curso);
        System.out.println(mentoria);*/

        BootCamp bootCamp = new BootCamp();

        bootCamp.setName("BootCamp Java Developer");
        bootCamp.setDescricao("BootCamp Java Developer");
        bootCamp.getConteudos().add(curso);
        bootCamp.getConteudos().add(mentoria);

        Dev dev = new Dev();

        dev.setName("Jonas");
        dev.increverBootCamp(bootCamp);

        System.out.println("Inscritos: " + dev.getConteudoInscritos());

        dev.progredir();
        dev.progredir();

        System.out.println("Inscritos: " + dev.getConteudoInscritos());
        System.out.println("Concluidos: " + dev.getConteudoConcluidos());
        System.out.println("XP: " + dev.calcularTotalXp());
    }
}
