package interfaces;

public interface ReprodutorMusical {
    void tocar();
    void pausar();
    String selecionarMusica(String musica);
    boolean escolherAlbum(String album);
    boolean escolherArtista(String artistaAtual);
    
}