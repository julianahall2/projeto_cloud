package br.edu.ibmec.todo.model;

import java.util.List;
import java.util.UUID;



public class Cartao {
    public UUID id;
    public Boolean ativo;
    public double limite;
    public String numero;
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
}
