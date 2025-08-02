package dio;

import dio.ui_custom.frame.MainFrame;
import dio.ui_custom.panel.MainPanel;
import dio.ui_custom.screen.MainScreen;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class UIMain {
    public static void main(String[] args) {
        final var gameConfig = Stream.of(args).collect(Collectors.toMap(
                k -> k.split(";")[0],
                v -> v.split(";")[1]));
        var mainScreen = new MainScreen(gameConfig);
        mainScreen.buildMainScreen();
    //     List<String> entradas = new ArrayList<>();

    //     if (args.length == 0) {
    //         System.out.println("Por favor, forneça o caminho para o arquivo de entrada.");
    //         return;
    //     }

    //     String caminhoArquivo = args[0];

    //     try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
    //         String linha;
    //         while ((linha = br.readLine()) != null) {
    //             entradas.add(linha);
    //         }
    //     } catch (IOException e) {
    //         System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    //         return;
    //     }

    //     // Agora, você pode usar o conteúdo de 'entradas' como faria com os args[]
    //     for (String entrada : entradas) {
    //         System.out.println("Processando entrada: " + entrada);
    //         // Aqui você pode reutilizar a lógica que usava para cada argumento args[i]
    //     }

    //     // Aqui você pode continuar a lógica do seu jogo de Sudoku com os dados lidos
    
     }
}
