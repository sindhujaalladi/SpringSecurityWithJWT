package com.springsecuritywithjwt.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {
	
	private String secret = "javajwtsecretkey";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

	public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

	private String createToken(Map<String, Object> claims, String username) {
		return	Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis())).setIssuer("SPRINGSECURITYWITHJWT")
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)).signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public Boolean validateToken(String token ,UserDetails userdetails) {
		final String username = extractUsername(token);
		return username.equals(userdetails.getUsername()) & !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());		
	}
}
