package com.wyden.padaria_server.controller;


import com.wyden.padaria_server.dto.UsuarioDTO;
import com.wyden.padaria_server.model.Usuario;
import com.wyden.padaria_server.repository.UsuarioRepository;
import com.wyden.padaria_server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@RequestBody Usuario user) {
        // Verificar se o nome de usuário já existe
        if (usuarioRepository.findByUsername(user.getUsername()) != null) {
            return "Nome de usuário já existe. Escolha outro.";
        }

        // Salvar usuário no banco de dados
        usuarioRepository.save(user);
        return "Usuário cadastrado com sucesso";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuarioDTO) {
        // Buscar usuário no banco de dados pelo nome de usuário
        Usuario usuario = usuarioRepository.findByUsername(usuarioDTO.getUsername());

        // Verificar se o usuário existe e se a senha está correta
        if (usuario != null && usuario.getPassword().equals(usuarioDTO.getPassword())) {
            // Se as credenciais são válidas, gere um token JWT
            String token = authService.generateToken(usuarioDTO.getUsername());
            return token;
        } else {
            // Tratar erro de autenticação
            return "Credenciais inválidas";
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/redirect")
    public ResponseEntity<String> redirect(@RequestHeader("Authorization") String token) {
        String role = authService.getRoleFromToken(token);
        if ("ADMIN".equals(role)) {
            return ResponseEntity.ok("redirect:admin.html");
        } else if ("USER".equals(role)) {
            return ResponseEntity.ok("redirect:user.html");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso não autorizado");
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/get-name")
    public ResponseEntity<String> getNameFromToken(@RequestHeader("Authorization") String token) {
        String name = authService.getNameFromToken(token);

        if (name != null) {
            return ResponseEntity.ok(name);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido ou expirado");
        }
    }
}
