package poo.restaurante;

public class Mesa {
    public Integer numeroMesa;
    private Integer numOcupantes;
    private boolean estaLivre = true;
    private Comanda comanda = new Comanda();
    private Integer capacidade;

    public Mesa (Integer numero) {
        this.numeroMesa = numero;
    }

    public void ocuparMesa(int numOcupantes) {
        if (numOcupantes<=this.capacidade && estaLivre) {
            this.numOcupantes = numOcupantes;
            this.estaLivre = false;
            this.comanda = new Comanda();
        }
        else {
            return;
        }
    }

    public void desocuparMesa(double valorPago) {
        Double total = comanda.calculaPreco();
        if (valorPago>=total) {
            this.numOcupantes = 0;
            this.estaLivre = true;
            this.comanda = null;
        }
    }

    @Override
    public String toString() {
        return this.numeroMesa.toString();
    }

    public Integer getNumOcupantes() {
        return numOcupantes;
    }

    public void setNumOcupantes(Integer numOcupantes) {
        this.numOcupantes = numOcupantes;
    }

    public boolean isEstaLivre() {
        return estaLivre;
    }

    public void setEstaLivre(boolean estaLivre) {
        this.estaLivre = estaLivre;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
}
