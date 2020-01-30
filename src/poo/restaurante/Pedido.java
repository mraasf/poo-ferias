package poo.restaurante;

public class Pedido {
    public Funcionario garcom = new Funcionario("Tonha",32,"88888808");
    public Prato prato =  new Prato();
    public Integer quantidade;

    public Pedido() {
        garcom.setNome("Tonha ");
        prato.setNome("buchada aos 4 queijos");
        prato.setValorPrato(15.75);
    }

    public Double calculaPreco() {
        return this.prato.getValor() * this.quantidade;
    }
}
