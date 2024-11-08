package com.example.todoapp.Services.impl;

import com.example.todoapp.Entity.User;
import com.example.todoapp.Models.UserInput;
import com.example.todoapp.Repository.UserRepository;
import com.example.todoapp.Services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Boolean getUserStatus(String email){
        Optional<User> user=userRepository.findByUserEmail(email);
        if(user.isPresent())
        {
            if(user.get().getCoupon()!=null)
            {
                return false;
            }
            else{
                return true;
            }
        }
        else{
            User newUser=new User();
            newUser.setUserEmail(email);
            userRepository.save(newUser);
            return true;
        }
    }

    public Boolean updateCoupon(String email,String coupon){
        int rowStatus=userRepository.updateCouponByUserEmail(email,coupon);
        return rowStatus>0;
    }

}
