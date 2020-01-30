package poo.restaurante;

public class Comanda {
    public Pedido[] pedidos;

    public Comanda(){
        pedidos = new Pedido[20];
        pedidos[0] = new Pedido();//criqa um arraylist de pedidos
    }

    public Double calculaPreco() {
        Double total = Double.valueOf(0);

        for (int i=0; i<pedidos.length; i++) {// gera os pedidos at[e o tamanho do array(lenght
            Pedido um = pedidos[i];
            total +=  um.calculaPreco();// soma os valores at[e chegar ao valor final do pedido
        }

        return total;// retorna o total
    }
}
