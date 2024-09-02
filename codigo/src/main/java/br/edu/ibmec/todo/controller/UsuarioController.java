package br.edu.ibmec.todo.controller;

import br.edu.ibmec.todo.model.Usuario;
import br.edu.ibmec.todo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@Validated
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Método POST para criar um novo usuário
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
        // Aqui você salva o usuário usando o serviço
        Usuario usuarioCriado = usuarioService.salvarUsuario(usuario);
        
        // Retornar o usuário criado com o status 201 Created
        return new ResponseEntity<>(usuarioCriado, HttpStatus.CREATED);
    }
}