package br.edu.ibmec.todo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.edu.ibmec.todo.model.Cartao;
import br.edu.ibmec.todo.model.Usuario;

@Service
public class UsuarioService {
    private static List<Usuario> database = new ArrayList<>();

    public Usuario criarUsuario(String nome, String cpf, LocalDateTime dataNascimento) {
        Usuario usuario = new Usuario();
        
        //TODO: Validar CPF
        usuario.setCPF(cpf);
        usuario.setNome(nome);
        usuario.setDataNasc(dataNascimento);
        usuario.setId(UUID.randomUUID());
        
        database.add(usuario);

        return usuario;
    }

    public Usuario buscaUsuario(UUID id) {
        return this.findUsuario(id);
    }

    public void associarCartao(Cartao cartao, UUID id) throws Exception {
        //Buscar usuario

        Usuario usuario = this.findUsuario(id);

        //Valida se encontrou o usuario
        if (usuario == null) {
            throw new Exception("Não encontrei o usuario");
        }

        //valida se o cartão está ativo
        if (cartao.getAtivo() == false) {
            throw new Exception("Não posso associar um cartão inativo ao usuário");
        }

        //Associa um cartão a um usuario
        usuario.associarCartao(cartao);

    }

    private Usuario findUsuario(UUID id) {
        for (Usuario item : database) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    
}