package com.example.springbootactions.repository;

import com.example.springbootactions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

         Optional<User> findByUserIdAndDeletedAtIsNull(Integer userId);

         boolean existsByEmail(String email);

         boolean existsByUserId(Integer userId);


         boolean findByUserId(Integer userId);
}
