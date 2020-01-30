package poo.restaurante.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestPrato {

    public static void main(String[] args) {
        Prato[] pratos ={
                new Prato("Macarrão com farofa", 15.50),
                new Prato("Camarão internacional", 45.2),
                new Prato("Pão com ovo", 5.30),
                new Prato("Queijo com goiabada", 8.50),
                new Prato("Miojo com salsicha", 12.2),
                new Prato("Coca cola", 5.0),
                new Prato("Bacalhão acebolado", 38.2),
                new Prato("Carne com mosquito", 22.3),
                new Prato("Carne de sol na nata", 39.2)
        };

        PratoDAO dao = PratoDAO.getInstance();
        for (Prato p : pratos) dao.save(p);

        System.out.println("Cardapio");
        for(Prato pr : dao.cardapio())
            System.out.println(pr.getId() + " " + pr.getNome()+ " " + pr.getPreco());
    }
}
