package com.example.springbootactions.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

         private Integer userId;
         private String firstName;
         private String lastName;
         private Integer age;
         private String email;
         private String password;

         private LocalDateTime createdAt;
         private LocalDateTime updatedAt;
         private LocalDateTime deletedAt;

}
