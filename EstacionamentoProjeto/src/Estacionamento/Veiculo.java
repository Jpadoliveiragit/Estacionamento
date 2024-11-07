package Estacionamento;

public class Veiculo {
    String placa;
    String modelo;
    String tamanho;
    String horaEntrada;
    String horaSaida;

    public Veiculo(String placa, String modelo, String tamanho, String horaEntrada) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.horaEntrada = horaEntrada;
        this.horaSaida = null; 
    }
}
