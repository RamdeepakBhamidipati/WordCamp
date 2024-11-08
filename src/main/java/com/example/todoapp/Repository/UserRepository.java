package com.example.todoapp.Repository;

import com.example.todoapp.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByUserEmail(String userEmail);

    @Modifying
    @Transactional
    @Query("UPDATE users u SET u.coupon = :coupon WHERE u.userEmail = :userEmail")
    int updateCouponByUserEmail(@Param("userEmail") String userEmail, @Param("coupon") String coupon);

}
