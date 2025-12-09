import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var sc = new Scanner(System.in);
        var option = -1;
        while(option != 5){
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - somar: ");
            System.out.println("2 - subtrair: ");
            System.out.println("3 - multiplicar: ");
            System.out.println("4 - dividir: ");
            System.out.println("5 - sair: ");
            option = sc.nextInt();

            if(option > 5 || option < 1){
                System.out.println("Insira uma opção valida");
                continue;
            }

            if (option == 5){
                break;
            }
        }
    }
}
