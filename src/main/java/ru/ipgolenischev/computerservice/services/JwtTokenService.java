package ru.ipgolenischev.computerservice.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import ru.ipgolenischev.computerservice.models.base.AbstractServiceUserServiceModel;

import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
@Service
public class JwtTokenService {
    private final String secret = "ComputerService";
    private final Dictionary<String,AbstractServiceUserServiceModel> tokens = new Hashtable<>();

    public String generateToken(AbstractServiceUserServiceModel user){

        String token = Jwts.builder().setSubject(user.getPhone()).setId(((Integer)user.getId()).toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+100000000))
                .signWith(SignatureAlgorithm.HS512,secret.getBytes()).compact();
        tokens.put(token,user);
        return token;
    }
    public AbstractServiceUserServiceModel findUserByToken(String token){
        return tokens.get(token);
    }

}
