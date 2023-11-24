package sgsits.cse.dis.user.jwt;

import io.jsonwebtoken.Jwts;

public class JwtResolver {

  private static final String jwtSecret = "jwtDisSecretKey";

  /*Why this method is made static?*/
  public static String getUsernameFromAuthHead(final String authHeader) {
    /*Bearer is a type of token, which has the key represented as "Bearer key"*/
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      return Jwts.parser()
              .setSigningKey(jwtSecret)
              /*Extracting key from token*/
              .parseClaimsJws(authHeader.replace("Bearer ", ""))
              .getBody()
              .getSubject();
    }
    return null;
  }

  public String getUserNameFromJwtToken(String token) {
    String jwtKey = getJwt(token);
    System.out.println("token: "+token);
    System.out.println("jwtKey: "+jwtKey);
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtKey).getBody().getSubject();
  }

  public String getIdFromJwtToken(String token) {
    String jwtKey = getJwt(token);
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtKey).getBody().getId();
  }

  /*Return jwtKey*/
  private String getJwt(String authHeader) {

    /*Returing key by extracting it from token*/
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      return authHeader.replace("Bearer ", "");
    }
    return null;
  }
}