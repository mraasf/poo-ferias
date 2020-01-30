package tads.poo;

public class Circulo {
    private double raio;
    public static final double PI = 3.1415;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double calculaArea() {
        return PI*raio*raio;
    }

    public double calculaPerimetro() {
        return 2*PI*raio;
    }

    public boolean ehMaior(final Circulo c) {
        return this.raio > c.raio;
    }
}
