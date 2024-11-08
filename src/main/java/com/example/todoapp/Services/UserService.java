package com.example.todoapp.Services;

import com.example.todoapp.Entity.User;
import com.example.todoapp.Models.UserInput;

public interface UserService {

    public Boolean getUserStatus(String email);

    public Boolean updateCoupon(String email,String coupon);
}
