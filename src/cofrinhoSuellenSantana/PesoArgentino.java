package cofrinhoSuellenSantana;

public class PesoArgentino extends Moeda {
	// taxa de conversão fixa do dólar para real 
    private static final double TAXA_CONVERSAO = 0.0601;

    public PesoArgentino(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor * TAXA_CONVERSAO;
    }
    // para sobrescrever o método toString para exibir o símbolo da moeda (ARS)
    @Override
    public String toString() {
        return "ARS " + valor;
    }
}