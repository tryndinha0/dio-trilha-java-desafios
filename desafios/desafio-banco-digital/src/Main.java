public class Main {
    public static void main(String[] args) {
        // Criação do Banco Central
        BancoCentral bc = new BancoCentral();

        // Criação de um Banco
        Banco bancoDigital = new Banco("Banco Digital");
        bc.adicionarBanco(bancoDigital);

        // Criação de Clientes
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Cliente maria = new Cliente();
        maria.setNome("Maria");

        // Criação de Contas
        Conta ccVenilton = new ContaCorrente(venilton);
        Conta cpVenilton = new ContaPoupanca(venilton);
        Conta ccMaria = new ContaCorrente(maria);

        // Adicionando contas ao banco
        bancoDigital.adicionarConta(ccVenilton);
        bancoDigital.adicionarConta(cpVenilton);
        bancoDigital.adicionarConta(ccMaria);

        // Operações nas contas
        ccVenilton.depositar(250);
        ccVenilton.transferir(100, cpVenilton);
        cpVenilton.sacar(20);
        ccMaria.depositar(500);

        // Imprimindo extratos individuais
        System.out.println("\n--- Extratos Individuais ---");
        ccVenilton.imprimirExtrato();
        System.out.println();
        cpVenilton.imprimirExtrato();
        System.out.println();
        ccMaria.imprimirExtrato();

        // Listando todas as contas do banco
        System.out.println("\n--- Listagem de Contas do Banco ---");
        bancoDigital.listarContas();

        // Relatório completo do Banco Central
        bc.listarTodosBancosEContas();
    }
}