package nutricion.hexagonal.dominio.logica;

import java.security.Key;
import java.security.SignatureException;

import org.springframework.stereotype.Component;

import nutricion.hexagonal.config.JwtProperties;
import nutricion.hexagonal.dominio.interfaces.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenService implements Token {
    private final JwtProperties jwtProperties;

    public TokenService(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    @Override
    public String generarToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .signWith(getSigningKey(),SignatureAlgorithm.HS512)
                .compact();
    }

    @Override
    public boolean validarToken(String token) {
        try {
            // Parseamos el token para verificar la firma y la validez
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token); // Si el token no es válido, se lanzará una excepción

            return true; // Si no hay excepciones, el token es válido
        } catch (ExpiredJwtException e) {
            // El token ha expirado
            System.out.println("Token expirado.");
        } catch (Exception e) {
            // Otros errores generales de JWT
            System.out.println("Token inválido.");
        }
        return false;
    }

    @Override
    public String extraerUserId(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject(); // Devuelve el userId del token
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtProperties.getJwtSecret().getBytes());
    }
}

// Implementa los demás métodos...
