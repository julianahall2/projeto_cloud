package br.edu.ibmec.todo.controller;

import br.edu.ibmec.todo.model.Cartao;
import br.edu.ibmec.todo.model.Transacao;
import br.edu.ibmec.todo.repository.CartaoRepository;
import br.edu.ibmec.todo.repository.TransacaoRepository;
import br.edu.ibmec.todo.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public List<Transacao> getAllTransacoes() {
        return transacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> getTransacaoById(@PathVariable int id) {
        Optional<Transacao> transacao = transacaoRepository.findById(id);
        return transacao.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createTransacao(@RequestBody Transacao transacaoRequest) {
        try {
            // Supondo que o Cartão esteja associado à transação (você pode passar o ID do cartão no corpo da requisição)
            Optional<Cartao> cartaoOptional = cartaoRepository.findById(transacaoRequest.getCartao().getId());
            if (cartaoOptional.isPresent()) {
                Cartao cartao = cartaoOptional.get();
                Transacao transacao = transacaoService.autorizacaoTransacao(cartao, transacaoRequest.getValor(), transacaoRequest.getComerciante());
                return ResponseEntity.ok(transacao);
            } else {
                return ResponseEntity.badRequest().body("Cartão não encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> updateTransacao(@PathVariable int id, @RequestBody Transacao transacaoDetails) {
        return transacaoRepository.findById(id)
                .map(transacao -> {
                    transacao.setDataTransacao(transacaoDetails.getDataTransacao());
                    transacao.setValor(transacaoDetails.getValor());
                    transacao.setComerciante(transacaoDetails.getComerciante());
                    Transacao updatedTransacao = transacaoRepository.save(transacao);
                    return ResponseEntity.ok(updatedTransacao);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
