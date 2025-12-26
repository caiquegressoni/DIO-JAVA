import enumeration.OperationEnum;

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

            var selectOption = OperationEnum.values() [option -1];

            System.out.println("Informe o primeiro valor: ");
            var value1 = sc.nextInt();
            System.out.println("Informe o segundo valor: ");
            var value2 = sc.nextInt();

            var result = selectOption.getCalculate().apply(value1, value2);
            System.out.printf("%s %s %s = %s\n", value1, selectOption.getSynbol(), value2, result);
        }
    }
}
