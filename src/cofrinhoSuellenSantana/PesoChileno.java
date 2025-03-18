package cofrinhoSuellenSantana;

public class PesoChileno extends Moeda {
	// taxa de conversão fixa do dólar para real 
    private static final double TAXA_CONVERSAO = 0.00625;

    public PesoChileno(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor * TAXA_CONVERSAO;
    }
    // para sobrescrever o método toString para exibir o símbolo da moeda (CLP)
    @Override
    public String toString() {
        return "CLP " + valor;
    }
}