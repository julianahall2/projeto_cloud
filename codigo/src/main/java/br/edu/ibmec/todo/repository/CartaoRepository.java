package br.edu.ibmec.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.todo.model.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
    
}
