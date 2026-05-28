package br.com.dio;

import br.com.dio.model.Board;
import br.com.dio.model.Space;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Main {

    private final static Scanner sc = new Scanner(System.in);

    private static Board board;

    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        final var positions = Stream.of(args)
                .collect(Collectors.toMap(
                        k -> k.split(",")[0],
                        v -> v.split(",")[1]
                ));
        var option = 1;
        while (true) {
            System.out.println("Selecione uma das opções a seguir: ");
            System.out.println("1 - Iniciar um novo jogo: ");
            System.out.println("2 - Colocar um novo numero: ");
            System.out.println("3 - Remover um numero: ");
            System.out.println("4 - Visualizar jogo atual: ");
            System.out.println("5 - Verificar status do jogo: ");
            System.out.println("6 - Limpar jogo: ");
            System.out.println("7 - Finalizar jogo: ");
            System.out.println("8 - Sair: ");

            option = sc.nextInt();

            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> cleanGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção Invalida, selecione uma das opções validas! (1 a 8)");
            }
        }
    }

    private static void startGame(Map<String, String> positions) {
        if(nonNull(board)){
            System.out.println("Jogo já iniciado!");
            return;
        }
        List<List<Space>> spaces = new ArrayList<>();
        for(int i = 0; i < BOARD_LIMIT; i++){
            spaces.add(new ArrayList<>());
            for(int j = 0; j < BOARD_LIMIT; j++){
                var positionConfig = positions.get("%s, %s".formatted(i, j));
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                var currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }

        board = new Board(spaces);
    }

    private static void inputNumber() {
        if(isNull(board)){
            System.out.println("O jogo ainda nao foi iniciado!");
            return;
        }
        System.out.println("Informe a coluna que desja inserir: ");
    }

    private static void finishGame() {
    }

    private static void cleanGame() {
    }

    private static void showGameStatus() {
    }

    private static void showCurrentGame() {
    }

    private static void removeNumber() {
    }
}
