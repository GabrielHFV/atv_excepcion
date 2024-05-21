public class TesteContaBancaria {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000.00); // Saldo inicial de 1000.00

        try {
            conta.depositar(200.00);
            conta.sacar(500.00);
            conta.sacar(800.00); // Este saque deve lançar a exceção
        } catch (SaldoInsuficienteException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
