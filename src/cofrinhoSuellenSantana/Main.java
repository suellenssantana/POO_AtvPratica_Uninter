package cofrinhoSuellenSantana;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	// mapa que associa o tipo interno da moeda ao nome definido
    private static final Map<String, String> NOME_MOEDAS = new HashMap<>();

 // bloco estático para inicializar o mapa com os nomes das moedas
    static {
        NOME_MOEDAS.put("Dolar", "Dólar (USD)");
        NOME_MOEDAS.put("DolarCanadense", "Dólar Canadense (CAD)");
        NOME_MOEDAS.put("Euro", "Euro (EUR)");
        NOME_MOEDAS.put("Libra", "Libra Esterlina (GBP)");
        NOME_MOEDAS.put("PesoArgentino", "Peso Argentino (ARS)");
        NOME_MOEDAS.put("PesoChileno", "Peso Chileno (CLP)");
        NOME_MOEDAS.put("Real", "Real (BRL)");
        NOME_MOEDAS.put("Yen", "Yen (JPY)");
    }

    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
        	// exibir o menu principal
            System.out.println("\n------------------------------------------------------");
            System.out.println("***** Cofrinho | Suellen Santana - RU 4675033 *****");
            System.out.println("   USD | CAD | EUR | GBP | ARS | CLP | BRL | JPY\n");
            System.out.println(" Menu do que você pode fazer no cofrinho hoje:");
            System.out.println("  1. Adicionar moeda");
            System.out.println("  2. Remover moeda");
            System.out.println("  3. Listar moedas inseridas");
            System.out.println("  4. Ver o valor total em reais");
            System.out.println("  5. Sair\n");
            System.out.print("Escolha uma opção acima: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> adicionarMoeda(cofrinho, scanner);
                case 2 -> removerMoeda(cofrinho, scanner);
                case 3 -> listarMoedas(cofrinho);
                case 4 -> System.out.printf("Total em Reais: R$ %.2f%n", cofrinho.calcularTotalEmReais());
                case 5 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void adicionarMoeda(Cofrinho cofrinho, Scanner scanner) {
    	// para exibir os tipos de moedas disponíveis para adicionar
        System.out.println("\nMoedas compatíveis:");
        System.out.println("  1. Dólar | 2. Dólar Canadense | 3. Euro | 4. Libra Esterlina");
        System.out.println("  5. Peso Argentino | 6. Peso Chileno | 7. Real | 8. Yen");
        System.out.print("\nQual moeda deseja adicionar? ");
        int tipoMoeda = scanner.nextInt();

        // para mapear a escolha do usuário para o tipo interno da moeda
        String nomeMoeda = switch (tipoMoeda) {
            case 1 -> "Dolar";
            case 2 -> "DolarCanadense";
            case 3 -> "Euro";
            case 4 -> "Libra";
            case 5 -> "PesoArgentino";
            case 6 -> "PesoChileno";
            case 7 -> "Real";
            case 8 -> "Yen";
            default -> null;
        };

        if (nomeMoeda == null) {
            System.out.println("\nMoeda inválida, tente novamente.");
            return;
        }

        System.out.printf("\nQuantos %s você deseja adicionar? Informe o valor: ", NOME_MOEDAS.get(nomeMoeda));
        double valor = scanner.nextDouble();
        cofrinho.adicionarMoeda(nomeMoeda, valor);

        System.out.printf("\nAdicionado %.2f %s ao cofrinho com sucesso!\n", valor, NOME_MOEDAS.get(nomeMoeda));
    }

    private static void removerMoeda(Cofrinho cofrinho, Scanner scanner) {
        System.out.println("\nMoedas disponíveis no cofrinho:");
        listarMoedas(cofrinho);

     // para solicitar o tipo da moeda a ser removida
        System.out.print("\nQual moeda deseja remover? ");
        System.out.println(" * Escreva Dolar para remover Dólar Americano (USD)");
        System.out.println(" * Escreva DolarCanadense para remover Dólar Canadense (CAD)");
        System.out.println(" * Escreva Euro para remover Euro (EUR)");
        System.out.println(" * Escreva Libra para remover Libra Estrelina (GBP)");
        System.out.println(" * Escreva PesoArgentino para remover Peso Argentino (ARS)");
        System.out.println(" * Escreva PesoChileno para remover Peso Chileno (CLP)");
        System.out.println(" * Escreva Real para remover Real (BRL)");
        System.out.println(" * Escreva Yen para remover Yen (JPY)\n");
        String tipoMoeda = scanner.next();
        
     // para verificar o nome completo da moeda
        String nomeCompletoMoeda = NOME_MOEDAS.get(tipoMoeda);
        if (nomeCompletoMoeda == null) {
            System.out.println("\nMoeda inválida, tente novamente.");
            return;
        }

        System.out.printf("\nQuantos %s você deseja remover? Informe o valor: ", nomeCompletoMoeda);
        double valor = scanner.nextDouble();

        // para tentar remover o valor do cofrinho
        boolean removido = cofrinho.removerMoeda(tipoMoeda, valor);
        if (removido) {
            System.out.printf("\nRemovido %.2f %s do cofrinho com sucesso!\n", valor, nomeCompletoMoeda);
        } else {
            System.out.printf("\nNão foi possível remover %.2f %s, verifique se o valor é válido.\n", valor, nomeCompletoMoeda);
        }
    }

    private static void listarMoedas(Cofrinho cofrinho) {
    	// exibe o total acumulado de cada moeda no cofrinho
        System.out.println("\nResumo das moedas no cofrinho:");
        cofrinho.getTotalPorTipo().forEach((tipo, total) -> 
            System.out.printf("- %s: %.2f\n", NOME_MOEDAS.get(tipo), total));
    }
}