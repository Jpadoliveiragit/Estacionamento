package Estacionamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estacionamento {
    List<Vaga> vagas;
    List<Veiculo> veiculos;
    List<String> historico;

    public Estacionamento() {
        vagas = new ArrayList<>();
        veiculos = new ArrayList<>();
        historico = new ArrayList<>();
    }

    public void cadastrarVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.disponibilidade && vaga.tamanho.equals(veiculo.tamanho)) {
                veiculo.horaEntrada = java.time.LocalTime.now().toString();
                veiculos.add(veiculo);
                vaga.disponibilidade = false;
                System.out.println("O Veiculo esta estacionado na vaga de numero " + vaga.numero);
                return;
            }
        }
        System.out.println("Nao ha vaga disponivel para o veiculo.");
    }

    public void registrarSaida(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.placa.equals(placa)) {
                veiculo.horaSaida = java.time.LocalTime.now().toString();
               
                long permanencia = java.time.Duration.between(java.time.LocalTime.parse(veiculo.horaEntrada), java.time.LocalTime.parse(veiculo.horaSaida)).toMinutes();
                double valor = calcularValor(permanencia);
                System.out.println("Valor a pagar: R$ " + valor);

               
                for (Vaga vaga : vagas) {
                    if (vaga.tamanho.equals(veiculo.tamanho) && !vaga.disponibilidade) {
                        vaga.disponibilidade = true;
                        break;
                    }
                }

               
                historico.add("Placa: " + veiculo.placa + ", Tempo: " + permanencia + " minutos, Valor: R$ " + valor);

                veiculos.remove(veiculo);
                return;
            }
        }
        System.out.println("Veículo não encontrado.");
    }

    private double calcularValor(long permanencia) {
        if (permanencia <= 60) {
            return 5.0;
        } else if (permanencia <= 180) {
            return 10.0;
        } else {
            return 15.0;
        }
    }

    public void gerarRelatorioOcupacao() {
        System.out.println("Relatório de Vagas Ocupadas:");
        for (Veiculo veiculo : veiculos) {
            for (Vaga vaga : vagas) {
                if (!vaga.disponibilidade && vaga.tamanho.equals(veiculo.tamanho)) {
                    System.out.println("Vaga número: " + vaga.numero + ", Tamanho: " + vaga.tamanho + ", Placa: " + veiculo.placa);
                }
            }
        }
    }

    public void gerarHistorico() {
        System.out.println("Histórico de Permanência:");
        for (String registro : historico) {
            System.out.println(registro);
        }
    }
}
