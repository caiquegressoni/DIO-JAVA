public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {

            int vitorias = 75;
            int derrotas = 20;

            String resultado = calcRank(vitorias, derrotas);

            System.out.println(resultado);
        }
    }

        public static String calcRank ( int vitorias, int derrotas){
            int saldoVitorias = vitorias - derrotas;
            String nivel;

            if (vitorias < 10) {
                nivel = "Ferro";
            } else if (vitorias >= 11 && vitorias <= 20) {
                nivel = "Bronze";
            } else if (vitorias >= 21 && vitorias <= 50) {
                nivel = "Prata";
            } else if (vitorias >= 51 && vitorias <= 80) {
                nivel = "Ouro";
            } else if (vitorias >= 81 && vitorias <= 90) {
                nivel = "Diamante";
            } else if (vitorias >= 91 && vitorias <= 100) {
                nivel = "Lendário";
            } else {
                nivel = "Imortal";
            }


            return "O Herói tem de saldo de " + saldoVitorias + " está no nível de " + nivel;
        }
    }