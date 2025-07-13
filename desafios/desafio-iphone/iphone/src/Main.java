import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria uma instância do seu iPhone
        Iphone meuIphone = new Iphone();
        // Cria um Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Exibe o menu de opções
            System.out.println("\n--- Menu do iPhone ---");
            System.out.println("1. Reprodutor Musical");
            System.out.println("2. Aparelho Telefônico");
            System.out.println("3. Navegador de Internet");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            // Lê a opção do usuário
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o nextInt()

            // Usa a estrutura switch para lidar com as opções
            switch (opcao) {
                case 1:
                    // Menu do Reprodutor Musical
                    int opcaoMusical;
                    do {
                        System.out.println("\n--- Reprodutor Musical ---");
                        System.out.println("1. Escolher Artista");
                        System.out.println("2. Escolher Álbum");
                        System.out.println("3. Selecionar Música");
                        System.out.println("4. Tocar Música");
                        System.out.println("5. Pausar Música");
                        System.out.println("0. Voltar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");
                        opcaoMusical = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoMusical) {
                            case 1:
                                System.out.print("Digite o nome do artista: ");
                                String artista = scanner.nextLine();
                                meuIphone.escolherArtista(artista);
                                break;
                            case 2:
                                System.out.print("Digite o nome do álbum: ");
                                String album = scanner.nextLine();
                                meuIphone.escolherAlbum(album);
                                break;
                            case 3:
                                System.out.print("Digite o nome da música: ");
                                String musica = scanner.nextLine();
                                meuIphone.selecionarMusica(musica);
                                break;
                            case 4:
                                meuIphone.tocar();
                                break;
                            case 5:
                                meuIphone.pausar();
                                break;
                            case 0:
                                System.out.println("Voltando ao Menu Principal...");
                                break;
                            default:
                                System.out.println("Opção inválida para Reprodutor Musical.");
                        }
                    } while (opcaoMusical != 0);
                    break;
                case 2:
                    // Menu do Aparelho Telefônico
                    int opcaoTelefonica;
                    do {
                        System.out.println("\n--- Aparelho Telefônico ---");
                        System.out.println("1. Ligar");
                        System.out.println("2. Atender");
                        System.out.println("3. Iniciar Correio de Voz");
                        System.out.println("0. Voltar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");
                        opcaoTelefonica = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoTelefonica) {
                            case 1:
                                System.out.print("Digite o número para ligar: ");
                                String numeroLigacao = scanner.nextLine();
                                meuIphone.ligar(numeroLigacao);
                                break;
                            case 2:
                                meuIphone.atender();
                                break;
                            case 3:
                                meuIphone.iniciarCorreioVoz();
                                break;
                            case 0:
                                System.out.println("Voltando ao Menu Principal...");
                                break;
                            default:
                                System.out.println("Opção inválida para Aparelho Telefônico.");
                        }
                    } while (opcaoTelefonica != 0);
                    break;
                case 3:
                    // Menu do Navegador de Internet
                    int opcaoNavegador;
                    do {
                        System.out.println("\n--- Navegador de Internet ---");
                        System.out.println("1. Exibir Página");
                        System.out.println("2. Adicionar Nova Aba");
                        System.out.println("3. Atualizar Página");
                        System.out.println("0. Voltar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");
                        opcaoNavegador = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoNavegador) {
                            case 1:
                                System.out.print("Digite a URL para exibir: ");
                                String urlExibir = scanner.nextLine();
                                meuIphone.exibirPagina(urlExibir);
                                break;
                            case 2:
                                System.out.print("Digite a URL para adicionar como nova aba: ");
                                String urlAdicionar = scanner.nextLine();
                                meuIphone.adicionarNovaAba(urlAdicionar);
                                break;
                            case 3:
                                meuIphone.atualizarPagina();
                                break;
                            case 0:
                                System.out.println("Voltando ao Menu Principal...");
                                break;
                            default:
                                System.out.println("Opção inválida para Navegador de Internet.");
                        }
                    } while (opcaoNavegador != 0);
                    break;
                case 0:
                    System.out.println("Desligando iPhone... Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 0);

        // Fecha o scanner para liberar recursos
        scanner.close();
    }
}
