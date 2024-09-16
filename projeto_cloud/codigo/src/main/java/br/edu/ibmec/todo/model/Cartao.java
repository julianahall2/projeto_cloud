package br.edu.ibmec.todo.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Cartao {
    public UUID id;
    public Boolean ativo;
    public double limite;
    public String numero;
    public List<Transacao> transacoes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID getId() {
        return id;
    }

    @Column
    public void setId(UUID id) {
        this.id = id;
    }

    @Column
    public Boolean getAtivo() {
        return ativo;
    }

    @Column
    public void setAtivo(Boolean ativo){
        this.ativo = ativo;
    }

    public double getLimite(){
        return limite;
    }

    public void setLimite(double limite){
        this.limite = limite;
    }

    public String getNumero(){
        return numero;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }
}
