package br.edu.ibmec.todo.service;

import br.edu.ibmec.todo.model.Cartao;
import br.edu.ibmec.todo.model.Usuario;
import br.edu.ibmec.todo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(String nome, String cpf, LocalDate dataNasc )throws Exception {
        Usuario usuario = new Usuario();
        
        if (!usuario.validarCPF(cpf)) {
            throw new Exception("CPF inválido!");
        }

        usuario.setCPF(cpf);
        usuario.setNome(nome);
        usuario.setDataNasc(dataNasc);
        usuario.setId(UUID.randomUUID());
        
        return usuarioRepository.save(usuario);  // Persistindo o usuário no banco
    }

    public Usuario salvarUsuario(Usuario usuario) throws Exception {
        if (!usuario.validarCPF(usuario.getCPF())) {
            throw new Exception("CPF inválido!");
        }

        return usuarioRepository.save(usuario);  // Salvando no banco de dados
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();  // Buscando do banco de dados
    }

    public Usuario buscaUsuario(UUID id) {
        return usuarioRepository.findById(id).orElse(null);  // Buscando usuário no banco
    }

    public void associarCartao(Cartao cartao, UUID id) throws Exception {
        Usuario usuario = buscaUsuario(id);

        if (usuario == null) {
            throw new Exception("Não encontrei o usuario");
        }

        if (!cartao.getAtivo()) {
            throw new Exception("Não posso associar um cartão inativo ao usuário");
        }

        usuario.associarCartao(cartao);
        usuarioRepository.save(usuario);  // Salvando a associação no banco
    }
}
