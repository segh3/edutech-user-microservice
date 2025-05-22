package com.edutech.usuarios.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.usuarios.users.model.Usuario;
import com.edutech.usuarios.users.service.UsuarioService;

@RestController
public class UsuarioController {
    @Autowired 
    private UsuarioService usuarioService;

    @PostMapping("/crearUsuario")
    public ResponseEntity<String> obtenerUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.crearUsuario(usuario));
    }

    @GetMapping("/obtenerUsuario/{correo}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String correo){
        Usuario usuario = usuarioService.obtenerUsuario(correo);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/actualizarUsuario")
    public ResponseEntity<String> actualizarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.actualizarUsuario(usuario));
    }


    @DeleteMapping("/eliminarUsuario/{correo}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String correo){
        return ResponseEntity.ok(usuarioService.eliminarUsuario(correo));
    }
}
