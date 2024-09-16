package br.edu.ibmec.todo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
