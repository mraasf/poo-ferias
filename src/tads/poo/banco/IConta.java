package tads.poo.banco;

import tads.poo.banco.exceptions.BancoException;
import tads.poo.banco.exceptions.SaldoInsuficienteException;
import tads.poo.banco.exceptions.ValorInvalidoException;

public interface IConta {
    Double saldo();
    void transferencia(IConta destino, Double valor) throws BancoException;
    void saque(Double valor) throws BancoException;
    void deposito(Double valor) throws ValorInvalidoException;
}
