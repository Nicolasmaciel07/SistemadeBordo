import java.util.Scanner;

public class ImortalNicolasEGiancarlo {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== IMORTAL-1 – SISTEMA DE BORDO ===");

        String novaSimulacao = "s";

        while (novaSimulacao.equalsIgnoreCase("s")) {

            int leitura = lerInteiroValido(scanner, "Quantas leituras serão realizadas? ", 3, 100);

            double[] array = new double[leitura];

            for (int i = 0; i < array.length; i++) {
                array[i] = Math.random() * 2000;
                System.out.printf("Leitura %d: %.2f%n", i + 1, array[i]);
            }

            System.out.println("--- MENU ---");
            System.out.println("1 - Média");
            System.out.println("2 - Máx/Mín");
            System.out.println("3 - Desvios");
            System.out.println("4 - Verificação de faixa");
            System.out.println("5 - Relatório");
            System.out.println("0 - Sair");

            double media = calcularMedia(array);
            double maximo = encontrarMaximo(array);
            double minimo = encontrarMinimo(array);

            boolean faixaDefinida = false;
            double min = 0.0;
            double max = 0.0;

            String outra = "s";

            while (outra.equalsIgnoreCase("s")) {
                int opcao = lerInteiroValido(scanner, "Escolha uma opção: ", 0, 5);

                if (opcao == 0) {
                    System.out.println("Saindo do menu de operações...");
                    outra = "n";
                } else {
                    switch (opcao) {
                        case 1 -> System.out.printf("Média das leituras: %.2f%n", media);
                        case 2 -> {
                            int posMax = -1, posMin = -1;
                            for (int i = 0; i < array.length; i++) {
                                if (posMax == -1 && array[i] == maximo) posMax = i + 1;
                                if (posMin == -1 && array[i] == minimo) posMin = i + 1;
                                if (posMax != -1 && posMin != -1) break;
                            }
                            System.out.printf("Valor máximo: %.2f (Leitura %d)%n", maximo, posMax);
                            System.out.printf("Valor mínimo: %.2f (Leitura %d)%n", minimo, posMin);
                        }
                        case 3 -> {
                            System.out.printf("Desvios em relação à média (%.2f):%n", media);
                            for (int i = 0; i < array.length; i++) {
                                System.out.printf("Leitura %d: %.2f | desvio: %.2f%n", i + 1, array[i], (array[i] - media));
                            }
                        }
                        case 4 -> {
                            min = lerDoubleValido(scanner, "Digite o mínimo aceitável: ");
                            max = lerDoubleValido(scanner, "Digite o máximo aceitável: ");
                            faixaDefinida = true;
                            verificarFaixa(min, max, array);
                        }
                        case 5 -> {
                            if (!faixaDefinida) {
                                min = lerDoubleValido(scanner, "Digite o mínimo aceitável: ");
                                max = lerDoubleValido(scanner, "Digite o máximo aceitável: ");
                                faixaDefinida = true;
                            }
                            exibirRelatorioCompleto(array, min, max, media, maximo, minimo);
                        }
                    }

                    System.out.print("Deseja realizar outra operação? (s/n): ");
                    outra = scanner.nextLine().trim().toLowerCase();
                }
            }

            System.out.print("Deseja iniciar nova simulação? (s/n): ");
            novaSimulacao = scanner.nextLine().trim().toLowerCase();

            if (novaSimulacao.equals("s")) {
                System.out.println("Iniciando nova simulação... Novas leituras serão sorteadas.");
            }
        }

        System.out.println("Encerrando sistema...");
        scanner.close();
    }


    private static int lerInteiroValido(Scanner scanner, String mensagem, int min, int max) {
        int valor = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();

            try {
                valor = Integer.parseInt(entrada);
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.printf("Valor inválido! Digite um número entre %d e %d.%n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números inteiros.");
            }
        }
        return valor;
    }


    private static double lerDoubleValido(Scanner scanner, String mensagem) {
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();

            try {
                valor = Double.parseDouble(entrada.replace(",", "."));
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número válido (use ponto ou vírgula como separador decimal).");
            }
        }
        return valor;
    }

    public static double calcularMedia(double[] x) {
        double soma = 0;
        for (double v : x) {
            soma += v;
        }
        return soma / x.length;
    }

    public static double encontrarMaximo(double[] x) {
        double max = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] > max) {
                max = x[i];
            }
        }
        return max;
    }

    public static double encontrarMinimo(double[] x) {
        double min = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
            }
        }
        return min;
    }

    public static void verificarFaixa(double min, double max, double[] armazenamento) {
        for (int i = 0; i < armazenamento.length; i++) {
            double valor = armazenamento[i];
            if (valor < min) {
                System.out.println("Leitura " + (i + 1) + ": ABAIXO DO LIMITE");
            } else if (valor > max) {
                System.out.println("Leitura " + (i + 1) + ": ACIMA DO LIMITE");
            } else {
                System.out.println("Leitura " + (i + 1) + ": OK");
            }
        }
    }

    public static void exibirRelatorioCompleto(double[] x, double min, double max,
                                                double media, double maximo, double minimo) {
        System.out.println("============ RELATÓRIO COMPLETO ============");
        System.out.println("Quantidade de leituras: " + x.length);

        System.out.println("Leituras:");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("Leitura %d: %.2f%n", i + 1, x[i]);
        }

        System.out.printf("Média: %.2f%n", media);

        int posMax = -1, posMin = -1;
        for (int i = 0; i < x.length; i++) {
            if (posMax == -1 && x[i] == maximo) posMax = i + 1;
            if (posMin == -1 && x[i] == minimo) posMin = i + 1;
            if (posMax != -1 && posMin != -1) break;
        }
        System.out.printf("Máximo: %.2f (Leitura %d)%n", maximo, posMax);
        System.out.printf("Mínimo: %.2f (Leitura %d)%n", minimo, posMin);

        System.out.println("Desvios em relação à média:");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("Leitura %d: %.2f%n", i + 1, (x[i] - media));
        }

        System.out.printf("Verificação de faixa (%.2f a %.2f):%n", min, max);
        verificarFaixa(min, max, x);

        System.out.println("============================================");
    }
}