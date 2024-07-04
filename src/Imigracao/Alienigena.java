package Imigracao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Alienigena extends Especie {
    private int id;
    private String nome;
    private LocalDateTime dataHoraEntrada;
    private boolean quarentenado;

    public Alienigena(String nomeEspecie, String planetaNatal, String nome) {
        super(nomeEspecie, planetaNatal);
        this.nome = nome;
        this.dataHoraEntrada = LocalDateTime.now();

        if (this.nivelPericulosidade == 100)
            this.quarentenado = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public boolean isQuarentenado() {
        return quarentenado;
    }

    public void setQuarentenado(boolean quarentenado) {
        this.quarentenado = quarentenado;
    }

    public void exibirDetalhes() {
        System.out.println("id: " + this.getId() + " nome: " + this.getNome() + " dataHoraEntrada: " + this.getDataHoraEntrada().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " quarentenado: " + this.isQuarentenado() + " nomeEspecie: " + this.getNomeEspecie() + " planetaNatal: " + this.getPlanetaNatal() + " nivelPericulosidade: " + this.getNivelPericulosidade());
    }
}