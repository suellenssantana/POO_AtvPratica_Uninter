package cofrinhoSuellenSantana;

public class DolarCanadense extends Moeda {
	// taxa de conversão fixa do dólar canadense para real 
    private static final double TAXA_CONVERSAO = 4.30;

    public DolarCanadense(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor * TAXA_CONVERSAO;
    }

 // para sobrescrever o método toString para exibir o símbolo da moeda (C$)
    @Override
    public String toString() {
        return "C$ " + valor;
    }
}