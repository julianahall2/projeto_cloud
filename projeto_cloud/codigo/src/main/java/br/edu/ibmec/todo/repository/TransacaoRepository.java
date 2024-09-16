package br.edu.ibmec.todo.repository;

import org.springframework.stereotype.Repository;

import br.edu.ibmec.todo.model.Usuario;

@Repository
public class TransacaoRepository extends JpaRepository<Transacao, Integer>{
    
}
