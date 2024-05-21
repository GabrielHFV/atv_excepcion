public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado: " + valor);
        System.out.println("Saldo atual: " + saldo);
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque de: " + valor);
        }
        saldo -= valor;
        System.out.println("Saque realizado: " + valor);
        System.out.println("Saldo atual: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}
