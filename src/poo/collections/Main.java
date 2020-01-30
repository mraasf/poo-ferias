package poo.collections;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Collection<String> list = null;
        Scanner s = new Scanner(System.in);

        String valor;
        do {
            valor=s.next();
            if (list==null) list = Factory.create(valor);
            list.add(valor);
        } while (valor.compareTo("0")==0);

        System.out.println("Elementos da coleção:");
        for (String i : list )
            System.out.print(i+ " ");
    }
}
