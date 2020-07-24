package com.github.vkvish19.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtTest1
{
    public static void main(String[] args)
    {
        String jwtEncoded = encode();
        System.out.println("jwtEncoded = " + jwtEncoded);
    
        boolean b = decode(jwtEncoded);
        System.out.println("b = " + b);
    }
    
    private static String encode()
    {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            return exception.getMessage();
        }
    }
    
    private static boolean decode(String token)
    {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            
            return true;
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            return false;
        }
    }
}
