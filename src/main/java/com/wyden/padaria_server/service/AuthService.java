package com.wyden.padaria_server.service;

import com.wyden.padaria_server.model.Usuario;
import com.wyden.padaria_server.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class AuthService {
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512); //criando uma chave aleatoria
    private static final long EXPIRATION_TIME = 864_000_000; // A chave expira em 10 dias

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String generateToken(String username) {
        String role = usuarioRepository.findByUsername(username).getRole();
        String name = usuarioRepository.findByUsername(username).getName();

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("name", name)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public String getRoleFromToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return claims.get("role", String.class);
        } catch (Exception e) {
            return null;
        }
    }

    public String getNameFromToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return claims.get("name", String.class);
        } catch (Exception e) {
            return null;
        }
    }


}

