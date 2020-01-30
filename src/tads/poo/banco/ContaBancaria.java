package tads.poo.banco;

import tads.poo.banco.exceptions.BancoException;
import tads.poo.banco.exceptions.SaldoInsuficienteException;
import tads.poo.banco.exceptions.ValorInvalidoException;

public class ContaBancaria implements IConta {
    private Double saldoConta;

    public ContaBancaria() {
        this.saldoConta=Double.valueOf(0.0);
    }

    @Override
    public Double saldo() {
        return this.saldoConta;
    }

    @Override
    public void transferencia(IConta destino, Double valor) throws BancoException {
        if (valor<=this.saldoConta && valor>0) {
            this.saque(valor);
            destino.deposito(valor);
        }
    }

    @Override
    public void saque(Double valor) throws BancoException {
        if (valor<0)
            throw new ValorInvalidoException(valor, this.saldoConta);
        if (valor>this.saldoConta)
            throw new SaldoInsuficienteException();
        this.saldoConta-=valor;
    }

    @Override
    public void deposito(Double valor) throws ValorInvalidoException {
        if (valor<0)
            throw new ValorInvalidoException(valor, this.saldoConta);

        this.saldoConta+=valor;
    }
}
