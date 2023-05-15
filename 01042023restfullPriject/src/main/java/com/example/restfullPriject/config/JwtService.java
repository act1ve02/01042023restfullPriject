package com.example.restfullPriject.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String ENCRIPTION_KEY = "112323123123123123123123123123123123123123";
    public String extractUsername(String jwtToken) {
        return extractClaim(jwtToken, Claims :: getSubject);
    }

    private Claims extractAllClaims(String jwtToken)    {
        return Jwts.parserBuilder().
                setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails)   {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+60000))
                .signWith(getSigningKey(), SignatureAlgorithm.ES256)
                .compact();
    }

    public String generateToken(UserDetails details)    {
        return generateToken(new HashMap<>(), details);
    }

    public boolean isTokenValid(String jwtToken, UserDetails details)   {
        final String username = extractUsername(jwtToken);
        return (username.equals(details.getUsername())) && !isTokenExpired(jwtToken);
    }

    private boolean isTokenExpired(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date());
    }

    private Date extractExpiration(String jwtToken) {
        return extractClaim(jwtToken, Claims::getExpiration);
    }

    public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(jwtToken);
        return claimsResolver.apply(claims);
    }

    private Key getSigningKey() {

        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(ENCRIPTION_KEY));
    }
}
