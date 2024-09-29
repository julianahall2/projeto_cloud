package br.edu.ibmec.todo.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Transacao {
    public UUID id;
    public LocalDateTime dataTransacao;
    public double valor;
    public String comerciante;

    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }
    
    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
}

