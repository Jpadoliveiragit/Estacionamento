package Estacionamento;

import java.util.Scanner;

public class GerenciamentoEstacionamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento();

        
        estacionamento.cadastrarVaga(new Vaga(1, "pequeno"));
        estacionamento.cadastrarVaga(new Vaga(2, "medio"));
        estacionamento.cadastrarVaga(new Vaga(3, "grande"));

        
        while (true) {
            System.out.println("1. Cadastrar Veiculo");
            System.out.println("2. Registrar Saida de Veiculo");
            System.out.println("3. Gerar Relatorio de Ocupacao");
            System.out.println("4. Gerar Historico");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.println("Digite a Placa:");
                    String placa = scanner.nextLine();
                    System.out.println("Qual o Modelo:");
                    String modelo = scanner.nextLine();
                    System.out.println("Qual Tamanho do carro (pequeno, medio, grande:");
                    String tamanho = scanner.nextLine();
                    Veiculo veiculo = new Veiculo(placa, modelo, tamanho, java.time.LocalTime.now().toString());
                    estacionamento.cadastrarVeiculo(veiculo);
                    break;
                case 2:
                    System.out.println("Placa do Veículo para Saida:");
                    String placaSaida = scanner.nextLine();
                    estacionamento.registrarSaida(placaSaida);
                    break;
                case 3:
                    estacionamento.gerarRelatorioOcupacao();
                    break;
                case 4:
                    estacionamento.gerarHistorico();
                    break;
                case 5:
                    System.out.println("Obrigado Ate Logo.");
                    return;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }
}
