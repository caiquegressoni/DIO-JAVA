import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite: ");
        String codigo = scanner.nextLine();

        if(codigo.equals("EC2")){
          System.out.println("EC2");
        }else if(codigo.equals("S3")){
          System.out.println("S3");
        }else if(codigo.equals("Lambda")){
          System.out.println("Lambda");
        }else{
          System.out.println("codigo invalido");
        }
        // TODO: Verifique se o código corresponde exatamente a "EC2", "S3" ou "Lambda" e imprima o serviço correspondente.
        // Caso contrário, imprima "Codigo invalido".
    }
}