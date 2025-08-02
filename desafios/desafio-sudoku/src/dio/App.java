package dio;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dio.model.Board;
import dio.model.Space;
import dio.util.BoardTemplate;

public class App {

    private final static Scanner scanner = new Scanner(System.in);

    private static Board board;

    private final static int BOARD_LIMIT = 9;

    private static final BoardTemplate BOARD_TEMPLATE = new BoardTemplate("""
            ****************************************************
            * -0--|-1--|-2--|--3--|-4--|-5--|--6--|-7--|-8--|
            *0| %s | %s | %s || %s | %s | %s || %s | %s | %s |0*
            * --------------------------------------------- *
            *1| %s | %s | %s || %s | %s | %s || %s | %s | %s |1*
            * --------------------------------------------- *
            *2| %s | %s | %s || %s | %s | %s || %s | %s | %s |2*
            ****************************************************
            *3| %s | %s | %s || %s | %s | %s || %s | %s | %s |3*
            * --------------------------------------------- *
            *4| %s | %s | %s || %s | %s | %s || %s | %s | %s |4*
            * --------------------------------------------- *
            *5| %s | %s | %s || %s | %s | %s || %s | %s | %s |5*
            *****************************************************
            *6| %s | %s | %s || %s | %s | %s || %s | %s | %s |6*
            * --------------------------------------------- *
            *7| %s | %s | %s || %s | %s | %s || %s | %s | %s |7*
            * --------------------------------------------- *
            *8| %s | %s | %s || %s | %s | %s || %s | %s | %s |8*
            * -0--|-1--|-2--|--3--|-4--|-5--|--6--|-7--|-8--|
            *****************************************************
            """);

    public static void main(String[] args) throws Exception {
        final var positions = Stream.of(args).collect(Collectors.toMap(
                k -> k.split(";")[0],
                v -> v.split(";")[1]));
        var option = -1;
        while (true) {
            System.out.println("Selecione uma das opcoes a seguir");
            System.out.println("1 - Iniciar um novo jogo");
            System.out.println("2 - Colocar um novo número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar o jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - Limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private static void startGame(final Map<String, String> positions) {
        if (nonNull(board)) {
            System.out.println("Jogo já foi iniciado");
            return;
        }

        
        System.out.println("O jogo está pronto para comecar");
    }

    private static void inputNumber() {
        if (isNull(board)) {
            System.out.println("O jogo ainda nao foi iniciado");
            return;
        }

        System.out.println("Informe a coluna em que o numero sera inserido");
        var col = runUntilGetValidNumber(0, 8);
        System.out.println("Informe a linha em que o numero sera inserido");
        var row = runUntilGetValidNumber(0, 8);
        System.out.printf("Informe o numero que irá entrar na posição [%s,%s]\n", col, row);
        var value = runUntilGetValidNumber(1, 9);
        if (!board.changeValue(col, row, value)) {
            System.out.printf("A posição [%s,%s] tem um valor fixo\n", col, row);
        }
    }

    private static void removeNumber() {
        if (isNull(board)) {
            System.out.println("O jogo ainda nao foi iniciado");
            return;
        }

        System.out.println("Informe a coluna em que o numero sera removido");
        var col = runUntilGetValidNumber(0, 8);
        System.out.println("Informe a linha em que o numero sera removido");
        var row = runUntilGetValidNumber(0, 8);
        if (!board.clearValue(col, row)) {
            System.out.printf("A posição [%s,%s] tem um valor fixo\n", col, row);
        }
    }

    private static void showCurrentGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda nao foi iniciado");
            return;
        }

        var args = new Object[81];
        var argPos = 0;
        for (int i = 0; i < BOARD_LIMIT; i++) {
            for (var col : board.getSpaces()) {
                args[argPos++] = " " + ((isNull(col.get(i).getActual())) ? " " : col.get(i).getActual());
            }
        }
        System.out.println("Seu jogo se encontra na seguinte forma: ");
        System.out.printf((BOARD_TEMPLATE) + "\n", args);
    }

    private static void showGameStatus() {
        if (isNull(board)) {
            System.out.println("O jogo ainda nao foi iniciado");
            return;
        }

        System.out.printf("O jogo se encontra atualmente no status %s\n", board.getStatus().getLabel());
        if (board.hasErrors()) {
            System.out.println("O jogo contem erros");
        } else {
            System.out.println("O jogo não contem erros");
        }
    }

    private static void clearGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda nao foi iniciado");
            return;
        }

        System.out.println("Voce tem certeza que quer limpar o jogo? (sim ou nao)");
        var confirm = scanner.next();
        while (!confirm.equalsIgnoreCase("sim") && !confirm.equalsIgnoreCase("nao")) {
            System.out.println("Digite sim ou nao.");
            confirm = scanner.next();
        }
        if (confirm.equalsIgnoreCase("sim")) {
            board.reset();
        }
    }

    private static void finishGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda nao foi iniciado");
            return;
        }

        if (board.gameIsFinished()) {
            System.out.println("Parabéns voce concluiu o jogo");
            showCurrentGame();
            board = null;
        } else if (board.hasErrors()) {
            System.out.println("Seu jogo contem erros, verifique seu board e ajuste");
        } else {
            System.out.println("Preencha todas as posições");
        }
    }

    private static int runUntilGetValidNumber(final int min, final int max) {
        var current = scanner.nextInt();
        while (current < min || current > max) {
            System.out.printf("informe um numero entre %s e %s\n", min, max);
            current = scanner.nextInt();
        }
        return current;
    }
}
