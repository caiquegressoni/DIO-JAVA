public class Main {
    String nome;
    int idade;
    String tipo;

    public Main(String nome, int idade, String tipo) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
    }

    public static void main(String[] args) {
        Main hero1 = new Main("Arthus", 30, "mago");
        Main hero2 = new Main("Ryu", 25, "ninja");
        Main hero3 = new Main("Thor", 40, "guerreiro");

        hero1.atacar();
        hero2.atacar();
        hero3.atacar();
    }

    public void atacar() {
        String ataque = "";

        // Estrutura de decisão
        if (tipo.equalsIgnoreCase("mago")) {
            ataque = "magia";
        } else if (tipo.equalsIgnoreCase("guerreiro")) {
            ataque = "espada";
        } else if (tipo.equalsIgnoreCase("monge")) {
            ataque = "artes marciais";
        } else if (tipo.equalsIgnoreCase("ninja")) {
            ataque = "shuriken";
        } else {
            ataque = "um ataque desconhecido";
        }

        System.out.println("O " + tipo + " atacou usando " + ataque);
    }

}
