package br.ufrn.tads.poo;

import tads.poo.Circulo;
import tads.poo.Retangulo;

public class Main {
    public static void main(String[] args) {
        Retangulo r = new Retangulo(null, 4);

        System.out.println("Area de r:" + r.calculaArea());

        Integer a = null;
        Integer b = 3;
        System.out.println(a+b);

        r = new Retangulo(3, 4);
        System.out.println("Area de r: "+ r.calculaArea());

    }
}
