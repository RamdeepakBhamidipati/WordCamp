package com.example.todoapp.controllers;

import com.example.todoapp.Entity.User;
import com.example.todoapp.Models.UserInput;
import com.example.todoapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/wordCamp")
@RestController
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/userStatus")
    public ResponseEntity<Boolean> getUserStatus(@RequestParam("userEmail") String userEmail)
    {
        Boolean response=userService.getUserStatus(userEmail);

        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // User Login
    @PutMapping("/updateCoupon")
    public ResponseEntity<String> updateCoupon(@RequestParam("userEmail") String userEmail,@RequestParam("coupon") String coupon) {
        boolean status = userService.updateCoupon(userEmail, coupon);
        if(status)
        {
            return  new ResponseEntity<>("Updated coupon successfully", HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>("Error in adding coupon", HttpStatus.BAD_REQUEST);
        }
    }

}
