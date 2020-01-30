package tads.poo.banco.exceptions;

public class ValorInvalidoException extends BancoException {
    private Double valor;
    private Double saldo;
    public ValorInvalidoException(Double valor, Double saldo) {
        this.valor = valor;
        this.saldo = saldo;
    }

    public Double getValor() {
        return this.valor;
    }

    public Double getSaldo() {
        return this.saldo;
    }
}
