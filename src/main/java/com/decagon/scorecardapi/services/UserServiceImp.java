package com.decagon.scorecardapi.services;

import com.decagon.scorecardapi.dto.LoginDto;
import com.decagon.scorecardapi.exception.AuthorizationException;
import com.decagon.scorecardapi.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService{

    private final AuthenticationManager authenticationManager;


    @Override
    public String login(LoginDto loginDto){
        Authentication auth= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        if(auth.isAuthenticated()){
            return "Bearer " + JwtService.generateToken
                    (new org.springframework.security.core.userdetails.User(loginDto.getEmail(), loginDto.getPassword(),
                            new ArrayList<>()));
        }else{
            throw new AuthorizationException("Email or password Not Authenticated ");
        }
    }
}
