package Tuan.HCMUTESocial.service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtService {
	
	private String secretKey;
	private long jwtExpiration;
	private long refreshExpiration;
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAll
	}
	
//	kiểm tra tính hợp lệ của token
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
//	kiểm tra thời hạn của token
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
//	lấy thời hạn của token
	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
//	giải mã thông tin từ token
	private Claims extractAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSignInKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
//	tạo Key với secretkey	
	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
}
