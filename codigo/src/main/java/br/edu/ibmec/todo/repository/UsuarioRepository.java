package br.edu.ibmec.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import br.edu.ibmec.todo.model.Usuario;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    
    @Query("SELECT u FROM Usuario u JOIN u.cartoes c WHERE c.id = ?1")
    Usuario findUsuariobyCartao(UUID id_cartao);
}
