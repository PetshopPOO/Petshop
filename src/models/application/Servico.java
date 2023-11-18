package models.application;

public class Servico {
    private static int codigo = 0;
    private String tipo;
    private double valor;
    
    public Servico(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        codigo++;
    }

    public static int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
}
