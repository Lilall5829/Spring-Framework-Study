package com.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    //Authentication
    //assume: name - lila, password - 123
    public boolean authenticate(String username, String password){
        boolean isValidUserName = username.equalsIgnoreCase("lila");
        boolean isVaildPassword = password.equalsIgnoreCase("123");

        return isValidUserName && isVaildPassword;
    }
}
