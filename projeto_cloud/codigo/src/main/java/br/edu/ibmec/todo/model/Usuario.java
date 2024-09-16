package br.edu.ibmec.todo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    @NotBlank(message = "O id é obrigatório")
    private int id;

    @Column
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Column
    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @Column
    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    @Column
    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    @Column
    @NotBlank(message = "A data de nascimento é obrigatória")
    private LocalDateTime dataNasc;

    @OneToMany
    @JoinColumn(referencedColumnName = "id", name = "usuario_id")
    private List<Cartao> cartoes;

    public void associarCartao(Cartao cartao) {
        this.cartoes.add(cartao);
    }

    // Getters e Setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDateTime dataNasc) {
        this.dataNasc = dataNasc;
    }


}
