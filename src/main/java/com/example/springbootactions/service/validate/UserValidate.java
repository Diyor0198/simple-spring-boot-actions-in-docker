package com.example.springbootactions.service.validate;

import com.example.springbootactions.dto.ErrorDto;
import com.example.springbootactions.dto.UserDto;
import com.example.springbootactions.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserValidate {

         private final UserRepository userRepository;
         public List<ErrorDto> validate(UserDto userDto){
                  List<ErrorDto> errors=new ArrayList<>();
                  if (userRepository.existsByEmail(userDto.getEmail())){
                           errors.add(new ErrorDto("Email ", "Email already exist! "));
                  }
                  return errors;
         }


         public List<ErrorDto> searchUser(Integer userId) {
                  List<ErrorDto> errors=new ArrayList<>();
                  if (!userRepository.existsByUserId(userId)){
                           errors.add(new ErrorDto("user", "user is not found!"));
                  }
                  return errors;
         }

}
