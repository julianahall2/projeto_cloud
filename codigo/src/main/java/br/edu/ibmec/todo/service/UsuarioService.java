package br.edu.ibmec.todo.service;

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

    public Usuario criarUsuario(String nome, String cpf, LocalDateTime dataNascimento) throws Exception {
        Usuario usuario = new Usuario();
        
        if (!usuario.validarCPF(cpf)) {
            throw new Exception("CPF inválido!");
        }

        usuario.setCPF(cpf);
        usuario.setNome(nome);
        usuario.setDataNasc(dataNascimento);
        usuario.setId(UUID.randomUUID());
        
        database.add(usuario);

        return usuario;
    }

    public Usuario salvarUsuario(Usuario usuario) throws Exception {
        if (!usuario.validarCPF(usuario.getCPF())) {
            throw new Exception("CPF inválido!");
        }
        
        usuario.setId(UUID.randomUUID()); 
        database.add(usuario);
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        return database;
    }

    public Usuario buscaUsuario(UUID id) {
        return this.findUsuario(id);
    }

    public void associarCartao(Cartao cartao, UUID id) throws Exception {
        Usuario usuario = this.findUsuario(id);

        if (usuario == null) {
            throw new Exception("Não encontrei o usuario");
        }

        if (!cartao.getAtivo()) {
            throw new Exception("Não posso associar um cartão inativo ao usuário");
        }

        usuario.associarCartao(cartao);
    }

    private Usuario findUsuario(UUID id) {
        return database.stream()
                       .filter(u -> u.getId().equals(id))
                       .findFirst()
                       .orElse(null);
    }
}
