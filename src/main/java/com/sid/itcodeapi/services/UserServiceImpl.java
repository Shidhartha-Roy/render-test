package com.sid.itcodeapi.services;

import com.sid.itcodeapi.entity.UserEntity;
import com.sid.itcodeapi.model.UserModel;
import com.sid.itcodeapi.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final long jwtExpirationMs = 86400000;

    @Override
    public UserEntity registerUser(UserModel userModel) {

        String email = userModel.getEmail();
        UserEntity existingUser = userRepository.findByEmail(email);

        if(existingUser != null){
            throw new IllegalArgumentException("Email already registered");
        }
        UserEntity user = new UserEntity();
        user.setEmail(userModel.getEmail());
        user.setFirstname(userModel.getFirstname());
        user.setLastname(userModel.getLastname());
        user.setPassword(userModel.getPassword());
        userRepository.save(user);
        return user;
    }

    @Override
    public UserEntity loginUser(String email, String password) {

        UserEntity user = userRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new IllegalArgumentException("Invalid password");
        }

        return user;
    }

    @Override
    public String generateJwtToken(UserEntity user) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        Claims claims = Jwts.claims().setSubject(user.getEmail());

        Date now = new Date();
        Date expiration = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }

    //Verify token function --> Couldn't find the error
//    @Override
//    public Claims verifyToken(String token) {
//        Jws<Claims> jws = Jwts.parserBuilder()
//                .setSigningKey(Keys.secretKeyFor(SignatureAlgorithm.HS256))
//                .build()
//                .parseClaimsJws(token);
//        return jws.getBody();
//    }


}
