import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import interfaces.AparelhoTelefonico;
import interfaces.NavegadorInternet;
import interfaces.ReprodutorMusical;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {
    long numero;
    String paginaAtual, artistaAtual, albumAtual, musicaAtual;
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> listaURL = new ArrayList<>();
    private Map<String, Map<String, ArrayList<String>>> acervoMusical = new HashMap<>();
    private boolean estaTocando = false;

    public Iphone() {
        
        Map<String, ArrayList<String>> albunsQueen = new HashMap<>();
        ArrayList<String> musicasQueenBohemian = new ArrayList<>();
        musicasQueenBohemian.add("Bohemian Rhapsody");
        musicasQueenBohemian.add("Love of My Life");
        albunsQueen.put("A Night at the Opera", musicasQueenBohemian);

        ArrayList<String> musicasQueenNews = new ArrayList<>();
        musicasQueenNews.add("We Will Rock You");
        musicasQueenNews.add("We Are The Champions");
        albunsQueen.put("News of the World", musicasQueenNews);
        acervoMusical.put("Queen", albunsQueen);

        
        Map<String, ArrayList<String>> albunsAdele = new HashMap<>();
        ArrayList<String> musicasAdele21 = new ArrayList<>();
        musicasAdele21.add("Rolling in the Deep");
        musicasAdele21.add("Someone Like You");
        albunsAdele.put("21", musicasAdele21);
        acervoMusical.put("Adele", albunsAdele);
    }

    boolean listaVazia() {
        boolean vazio = listaURL.size() == 0 ? true : false;
        return vazio;
    }

    public void exibirPagina(String url) {
        if (listaVazia()) {
            System.out.println("Adicione uma url primeiro");
        } else if (listaURL.contains(url)) {
            System.out.println("Estamos exibindo/atualizando a url " + url);
            paginaAtual = url;
        }

    }

    public void adicionarNovaAba(String url) {
        int i = 0;
        listaURL.add(i, url);
        paginaAtual = url;
        System.out.printf("A url %s foi adicionada com sucesso!", url);
        i++;
    }

    public void atualizarPagina() {
        exibirPagina(paginaAtual);
    }

    public void ligar(String numero) {
        Random random = new Random();
        for (int tentativas = 1; tentativas <= 3; tentativas++) {
            boolean ligou = random.nextInt(3) == 1;
            if (ligou) {
                System.out.println("Conseguimos ligar com " + tentativas + " tentivas");
                return;
            }
        }
        System.out.println("Não conseguimos ligar para o número " + numero);
    }

    public boolean atender() {

        System.out.println("Deseja atender o telefone? - true ou false");
        boolean atende = scanner.nextBoolean();
        return atende;
    }

    public void iniciarCorreioVoz() {
        System.out.println("Iniciando o correio de voz...");
    }

    public void tocar() {
        if (musicaAtual != null && !musicaAtual.isEmpty()) {
            if (!estaTocando) {
                System.out.println("Reproduzindo agora: " + musicaAtual + " de " + albumAtual + " do artista " + artistaAtual);
                estaTocando = true;
            } else {
                System.out.println("A música " + musicaAtual + " já está tocando.");
            }
        } else {
            System.out.println("Nenhuma música selecionada para tocar. Por favor, selecione um artista, um álbum e uma música.");
        }
    }

    public void pausar() {
         if (estaTocando) {
            System.out.println("Música " + musicaAtual + " pausada.");
            estaTocando = false;
        } else {
            System.out.println("Nenhuma música está tocando para ser pausada.");
        }
    }

    public String selecionarMusica(String musica) {
        if (artistaAtual == null) {
            System.out.println("Por favor, selecione um artista primeiro.");
            return null;
        }
        if (albumAtual == null) {
            System.out.println("Por favor, selecione um álbum primeiro.");
            return null;
        }
        if (acervoMusical.get(artistaAtual).get(albumAtual).contains(musica)) {
            this.musicaAtual = musica;
            this.estaTocando = false;
            System.out.println("Música selecionada: " + musica + ".");
            return musica;
        } else {
            System.out.println("Música '" + musica + "' não encontrada no álbum '" + albumAtual + "'.");
            return null;
        }
    }

    public boolean escolherAlbum(String album) {
        if (artistaAtual == null) {
            System.out.println("Por favor, selecione um artista primeiro.");
            return false;
        }
        if (acervoMusical.get(artistaAtual).containsKey(album)) {
            this.albumAtual = null;
            this.musicaAtual = null;
            this.estaTocando = false;
            System.out.println("Album selecionado: " + album);
            System.out.println("Musicas disponíveis para " + album + ": " + acervoMusical.get(artistaAtual).get(album));
            return true;
        }else{
            System.out.println("Artista não encontrado");
        return false;
        }
        
    }

    public boolean escolherArtista(String artistaAtual) {
        if (acervoMusical.containsKey(artistaAtual)) {
            this.artistaAtual = artistaAtual;
            this.albumAtual = null; // Reseta o álbum e a música ao mudar de artista
            this.musicaAtual = null;
            this.estaTocando = false;
            System.out.println("Artista selecionado: " + artistaAtual);
            System.out.println(
                    "Álbuns disponíveis para " + artistaAtual + ": " + acervoMusical.get(artistaAtual).keySet());
            return true;
        } else {
            System.out.println("Artista '" + artistaAtual + "' não encontrado no acervo.");
            return false;
        }
    }

    

}
