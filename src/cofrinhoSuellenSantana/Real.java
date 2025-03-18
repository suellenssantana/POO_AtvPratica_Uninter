package cofrinhoSuellenSantana;

public class Real extends Moeda {
    public Real(double valor) {
        super(valor);
    }
    
    //o real mantem o mesmo valor na conversão
    @Override
    public double converterParaReal() {
        return valor;
    }

    // para exibir o valor do real no formato (R$)
    @Override
    public String toString() {
        return "R$ " + valor;
    }
}