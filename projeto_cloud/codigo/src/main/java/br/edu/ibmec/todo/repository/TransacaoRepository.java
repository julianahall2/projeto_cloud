package br.edu.ibmec.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.todo.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

}