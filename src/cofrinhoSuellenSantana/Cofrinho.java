package cofrinhoSuellenSantana;

import java.util.HashMap;
import java.util.Map;

public class Cofrinho {
    private Map<String, Double> totalPorTipo; // guardar o total acumulado de cada tipo de moeda

    public Cofrinho() {
        this.totalPorTipo = new HashMap<>();
        inicializarMoedas(); // para iniciar todas as moedas com valor 0.
    }

    // iniciando o valor das moedas como 0
    private void inicializarMoedas() {
        totalPorTipo.put("Dolar", 0.0);
        totalPorTipo.put("DolarCanadense", 0.0);
        totalPorTipo.put("Euro", 0.0);
        totalPorTipo.put("Libra", 0.0);
        totalPorTipo.put("PesoArgentino", 0.0);
        totalPorTipo.put("PesoChileno", 0.0);
        totalPorTipo.put("Real", 0.0);
        totalPorTipo.put("Yen", 0.0);
    }

    public void adicionarMoeda(String tipo, double valor) {
        if (totalPorTipo.containsKey(tipo)) {
            totalPorTipo.put(tipo, totalPorTipo.get(tipo) + valor); // adicionar ao total existente
        } else {
            System.out.println("Tipo de moeda inválido.");
        }
    }

    public boolean removerMoeda(String tipo, double valor) {
        if (totalPorTipo.containsKey(tipo) && totalPorTipo.get(tipo) >= valor) {
            totalPorTipo.put(tipo, totalPorTipo.get(tipo) - valor); // subtrair do total existente
            return true;
        }
        return false; // para não permitir remover valores maiores do que o existente
    }

    public Map<String, Double> getTotalPorTipo() {
        return totalPorTipo;
    }

    public double calcularTotalEmReais() {
    	// as conversões específicas de acordo com cada moeda - cambio comercial, data de consulta: 08/12/2024
        double total = 0.0;
        total += totalPorTipo.get("Dolar") * 6.09; 
        total += totalPorTipo.get("DolarCanadense") * 4.30;
        total += totalPorTipo.get("Euro") * 6.43;
        total += totalPorTipo.get("Libra") * 7.76;
        total += totalPorTipo.get("PesoArgentino") * 0.0601;
        total += totalPorTipo.get("PesoChileno") * 0.00625;
        total += totalPorTipo.get("Real") * 1.0;
        total += totalPorTipo.get("Yen") * 0.0405;
        return total;
    }
}