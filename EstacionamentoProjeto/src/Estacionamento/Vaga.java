package Estacionamento;

public class Vaga {
    int numero;
    String tamanho;
    boolean disponibilidade;

    public Vaga(int numero, String tamanho) {
        this.numero = numero;
        this.tamanho = tamanho;
        this.disponibilidade = true; 
    }
}
