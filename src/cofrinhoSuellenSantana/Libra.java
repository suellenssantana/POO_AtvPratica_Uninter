package cofrinhoSuellenSantana;

public class Libra extends Moeda {
	// taxa de conversão fixa do dólar para real 
    private static final double TAXA_CONVERSAO = 7.76;

    public Libra(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor * TAXA_CONVERSAO;
    }

 // para sobrescrever o método toString para exibir o símbolo da moeda (£)
    @Override
    public String toString() {
        return "£ " + valor;
    }
}