package com.example.springbootactions.service;

import com.example.springbootactions.dto.ErrorDto;
import com.example.springbootactions.dto.ResponseDto;
import com.example.springbootactions.dto.UserDto;
import com.example.springbootactions.entity.User;
import com.example.springbootactions.repository.UserRepository;
import com.example.springbootactions.service.mapper.UserMapper;
import com.example.springbootactions.service.validate.UserValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

         private final UserRepository userRepository;
         private final UserValidate userValidate;
         private final UserMapper userMapper;

         public ResponseDto<UserDto> create(UserDto dto) {
                  List<ErrorDto> errors = this.userValidate.validate(dto);
                  if (!errors.isEmpty()) {
                           return ResponseDto.<UserDto>builder()
                                   .code(-2)
                                   .message("Validate error! ")
                                   .errors(errors)
                                   .build();
                  }
                  try {
                           User user = this.userRepository.save(userMapper.toEntity(dto));
                           return ResponseDto.<UserDto>builder()
                                   .success(true)
                                   .message("User successful create!")
                                   .data(userMapper.toDto(user))
                                   .build();
                  } catch (Exception e) {
                           return ResponseDto.<UserDto>builder()
                                   .code(-3)
                                   .message(String.format("User while saving error  " + e.getMessage()))
                                   .build();
                  }
         }

         public ResponseDto<UserDto> getById(Integer userId) {
                  return this.userRepository.findByUserIdAndDeletedAtIsNull(userId)
                          .map(user -> ResponseDto.<UserDto>builder()
                                  .success(true)
                                  .message("User successful get method!")
                                  .data(this.userMapper.toDto(user))
                                  .build())
                          .orElse(ResponseDto.<UserDto>builder()
                                  .code(-1)
                                  .message(String.format("User id is not found!" + userId))
                                  .build());
         }

         public ResponseDto<UserDto> update(UserDto dto, Integer userId) {
                  try {
                           return this.userRepository.findByUserIdAndDeletedAtIsNull(userId)
                                   .map(user -> {
                                            this.userMapper.update(user, dto);
                                            user.setUpdatedAt(LocalDateTime.now());
                                            this.userRepository.save(user);
                                            return ResponseDto.<UserDto>builder()
                                                    .success(true)
                                                    .message("User Successful update")
                                                    .data(this.userMapper.toDto(user))
                                                    .build();
                                   })
                                   .orElse(ResponseDto.<UserDto>builder()
                                           .code(-1)
                                           .message(String.format("User id is not found!" + userId))
                                           .build());

                  } catch (Exception e) {
                           return ResponseDto.<UserDto>builder()
                                   .code(-3)
                                   .message(String.format("User updating error!" + e.getMessage()))
                                   .build();
                  }
         }

         public ResponseDto<UserDto> delete(Integer userId) {
                  try {
                           return this.userRepository.findByUserIdAndDeletedAtIsNull(userId)
                                   .map(user -> {
                                            user.setDeletedAt(LocalDateTime.now());
                                            this.userRepository.save(user);
                                            return ResponseDto.<UserDto>builder()
                                                    .success(true)
                                                    .message("User Successful delete!")
                                                    .data(this.userMapper.toDto(user))
                                                    .build();
                                   })
                                   .orElse(ResponseDto.<UserDto>builder()
                                           .code(-1)
                                           .message(String.format("User id is not found!" + userId))
                                           .build());

                  } catch (Exception e) {
                           return ResponseDto.<UserDto>builder()
                                   .code(-3)
                                   .message(String.format("User deleting error!" + e.getMessage()))
                                   .build();
                  }
         }

         public ResponseDto<List<UserDto>> getAll() {
                  try {
                           return ResponseDto.<List<UserDto>>builder()
                                   .success(true)
                                   .message("User getAll method successful!")
                                   .data(this.userRepository.findAll().stream().map(userMapper::toDto).toList())
                                   .build();
                  } catch (Exception e) {
                           return ResponseDto.<List<UserDto>>builder()
                                   .code(-3)
                                   .message(String.format("Users getAll method error!" + e.getMessage()))
                                   .build();
                  }
         }
}