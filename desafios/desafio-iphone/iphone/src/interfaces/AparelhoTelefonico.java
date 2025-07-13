package interfaces;

public interface AparelhoTelefonico {;
    public void ligar(String numero); //tentar ligar 3 vezes se atender, retornando
    boolean atender();
    void iniciarCorreioVoz();
    
}