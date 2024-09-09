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
}
