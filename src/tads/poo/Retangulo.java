package tads.poo;

public class Retangulo {
    private Integer base;
    private Integer altura;

    public Retangulo(Integer base, Integer altura) {
        if (base==null) base = 0;
        if (altura==null) altura = 0;
        this.base = base;
        this.altura = altura;
    }

    public int calculaArea() {
        return multiplicar();
    }

    private int multiplicar() {
        return this.base*this.altura;
    }
}
