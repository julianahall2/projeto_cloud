package br.edu.ibmec.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ibmec.todo.model.Cartao;
import br.edu.ibmec.todo.repository.CartaoRepository;

@RestController
@RequestMapping("/api/cartoes")
public class CartaoController {

    @Autowired
    private CartaoRepository cartaoRepository;

    
    @GetMapping
    public List<Cartao> getAllCartoes() {
        return cartaoRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Cartao> getCartaoById(@PathVariable int id) {
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        return cartao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<Cartao> createCartao(@RequestBody Cartao cartao) {
        Cartao novoCartao = cartaoRepository.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCartao);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Cartao> updateCartao(@PathVariable int id, @RequestBody Cartao cartaoAtualizado) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);

        if (!cartaoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Cartao cartaoExistente = cartaoOptional.get();
        cartaoExistente.setAtivo(cartaoAtualizado.getAtivo());
        cartaoExistente.setLimite(cartaoAtualizado.getLimite());
        cartaoExistente.setNumero(cartaoAtualizado.getNumero());
        cartaoExistente.setTransacoes(cartaoAtualizado.getTransacoes());
        cartaoExistente.setUsuario(cartaoAtualizado.getUsuario());

        Cartao cartaoAtualizadoNoBanco = cartaoRepository.save(cartaoExistente);
        return ResponseEntity.ok(cartaoAtualizadoNoBanco);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartao(@PathVariable int id) {
        if (!cartaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        cartaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
