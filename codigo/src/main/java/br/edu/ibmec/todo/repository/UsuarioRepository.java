package br.edu.ibmec.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.todo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT * FROM usuario u JOIN cartao c on u.id = c.usuario_id where id_cartao = ?1")
    Usuario fidUsuariobyUsuario(int id_cartao);
}
