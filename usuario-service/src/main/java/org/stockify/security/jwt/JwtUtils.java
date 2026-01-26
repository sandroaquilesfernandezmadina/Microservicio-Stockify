package org.stockify.security.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    //declaracion de la llave secreta pára la firma
    private final Key key = Keys.hmacShaKeyFor(
            "stockify-secret-key-stockify-secret-key".getBytes()
    );

    //decalracion el tiempo de expitacion del token que seria 24 horas
    private final long jwtExpiracionMs = 86400000;

    //Geenrador de token cuando el usuario hace el login
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername()) // username
                .setIssuedAt(new Date())                // fecha creación
                .setExpiration(new Date(
                        System.currentTimeMillis() + jwtExpiracionMs
                ))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    //Se usa cuando llega una petición con Authorization: Bearer
    public String getUsernameFromToken(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
