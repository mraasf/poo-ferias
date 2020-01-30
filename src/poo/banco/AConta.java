package poo.banco;

public abstract class AConta {
    private String titular;

    /**
     * Realiza um saque
     * @param valor do saque
     * @return true se o saque foi realizado, false caso contrário
     */
    public abstract boolean saque(Integer valor);

    /**
     * Consulta o saldo
     * @return saldo da conta
     */
    public abstract Integer saldo();

    /**
     * Realiza uma transferência entre duas contas
     * @param destino conta destino
     * @param valor valor da transferência
     * @return true se a transferência foi bem sucedida, false caso contrário
     */
    public abstract boolean transferencia(AConta destino, Integer valor);

    /**
     * realiza um depósito na conta
     * @param valor valor a ser depositado
     * @return true se o depósito foi bem sucedido, false caso contrário
     */
    public abstract boolean deposito(Integer valor);

    protected void setTitular(String nome) {
        this.titular = nome;
    }

    /**
     * Recupera o nome do titular da conta
     * @return nome do titular
     */
    public String titular() {
        return this.titular;
    }
}
