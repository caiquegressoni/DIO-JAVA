package main.collections.list.Pesquisa;

public class Livro {
    private String autor;
    private String titulo;
    private int anoDePublicaco;

    public Livro(String autor, String titulo, int anoDePublicaco) {
        this.autor = autor;
        this.titulo = titulo;
        this.anoDePublicaco = anoDePublicaco;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoDePublicaco() {
        return anoDePublicaco;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", anoDePublicaco=" + anoDePublicaco +
                '}';
    }
}
