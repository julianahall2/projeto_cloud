package br.edu.ibmec.todo.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity
public class Cartao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;

    @Column
    public Boolean ativo;

    @Column
    public double limite;

    @Column
    public String numero;

    @OneToMany
    @JoinColumn(referencedColumnName = "id", name = "cartao_id")
    public List<Transacao> transacoes;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

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

    public List<Transacao> getTransacoes(){
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes){
        this.transacoes = transacoes;
    }
}
