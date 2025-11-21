import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String solicitacao = scanner.nextLine();

        String texto = solicitacao.toLowerCase();

        System.out.println("Detalhes da solicitação: ");
        solicitacao = scanner.nextLine();

        // TODO: Imprima o serviço AWS correspondente de acordo com as palavras-chave presentes na solicitação.
        if(texto.contains("Aplicações") || texto.contains("Aplicação")){
          System.out.println("Servidor ideal: EC2");
        }else if(texto.contains("Imagens") || texto.contains("Videos")){
          System.out.println("Servidor ideal: S3");
        }else if(texto.contains("Banco de dados") || texto.contains("banco de dados")){
          System.out.println("Servidor ideal: RDS");
        }else if(texto.contains("sem servidor") || texto.contains("executar sem servidor")){
          System.out.println("Servidor ideal: Lambda");
        }else if(texto.contains("inteligencia artificial") || texto.contains("IA")){
          System.out.println("Servidor ideal: Serviço desconhecido");
        }else{
          System.out.println("Solicitação inválida");
        }
    }
}