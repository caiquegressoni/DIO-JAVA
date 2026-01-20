import br.com.dio.calc.Operation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("Escolha o numero para operção que deseja realizar (1 - soma, 2 - subtração)");
        var operationOption = sc.nextInt();

        while (operationOption > 2 ||  operationOption < 1) {
            System.out.println("Escolha uma opção valida! (1 - soma, 2 - subtração)" );
            operationOption = sc.nextInt();
        }

        var selectedOperation = Operation.values()[operationOption -1];
        System.out.println("Informe os numeros que serão separados por virgula (ex.: 1,2,3,4)");
        var numbers = sc.next();
        var numberArray = Arrays.stream(numbers.split(","))
                .mapToLong(Long::parseLong).toArray();

        var result = selectedOperation.getOperationCallBack().exec(numberArray);

        System.out.printf("Resultado: %s\n" ,result);
    }
}
