package com.sid.itcodeapi.services;

import com.sid.itcodeapi.entity.UserEntity;
import com.sid.itcodeapi.model.UserLoginModel;
import com.sid.itcodeapi.model.UserModel;
import io.jsonwebtoken.Claims;

public interface UserService {
    UserEntity registerUser(UserModel userModel);


    UserEntity loginUser(String email, String password);

    String generateJwtToken(UserEntity user);

    //verifyToken functionality not working optimally
//    Claims verifyToken(String token);
}
