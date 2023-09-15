package com.example.springbootactions.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private Integer userId;
         @Column(name = "first_name")
         private String firstName;
         @Column(name = "last_name")
         private String lastName;
         @Column(name = "age")
         private Integer age;
         @Column(name = "email", unique = true)
         private String email;
         @Column(name = "password", unique = true)
         private String password;

         private LocalDateTime createdAt;
         private LocalDateTime updatedAt;
         private LocalDateTime deletedAt;

}
