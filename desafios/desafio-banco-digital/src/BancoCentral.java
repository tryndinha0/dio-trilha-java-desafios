import java.util.ArrayList;
import java.util.List;

public class BancoCentral {
    private List<Banco> bancos;

    public BancoCentral() {
        this.bancos = new ArrayList<>();
    }

    public void adicionarBanco(Banco banco) {
        this.bancos.add(banco);
    }

    public List<Banco> getBancos() {
        return bancos;
    }

    public void listarTodosBancosEContas() {
        System.out.println("=== Relatório do Banco Central ===");
        if (bancos.isEmpty()) {
            System.out.println("Nenhum banco registrado no Banco Central.");
            return;
        }
        for (Banco banco : bancos) {
            System.out.println("\n*** Banco: " + banco.getNome() + " ***");
            banco.listarContas();
        }
    }
}