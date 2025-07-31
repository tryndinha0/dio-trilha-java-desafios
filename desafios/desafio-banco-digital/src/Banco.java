import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public Banco(String nome){
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public void listarContas() {
        System.out.println("=== Contas do Banco " + this.nome + " ===");
        if (contas.isEmpty()) {
            System.out.println("Não há contas neste banco.");
            return;
        }
        for (Conta conta : contas) {
            conta.imprimirExtrato();
            System.out.println("--------------------");
        }
    }
}
