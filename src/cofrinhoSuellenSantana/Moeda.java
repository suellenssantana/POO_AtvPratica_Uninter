package cofrinhoSuellenSantana;

public abstract class Moeda {
    protected double valor;

    // inicializar o valor da moeda
    public Moeda(double valor) {
        this.valor = valor;
    }

    // obter o valor da moeda
    public double getValor() {
        return valor;
    }
    // alterar o valor da moeda
    public void setValor(double valor) {
        this.valor = valor;
    }

    public abstract double converterParaReal();
    // para retornar uma representação em string da moeda
    @Override
    public abstract String toString();
}