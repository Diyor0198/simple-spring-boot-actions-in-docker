package com.example.springbootactions.controller;

import com.example.springbootactions.dto.ResponseDto;
import com.example.springbootactions.dto.UserDto;
import com.example.springbootactions.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
         private final UserService userService;

         @PostMapping("")
         public ResponseDto<UserDto> create(@RequestBody UserDto dto) {
                  return this.userService.create(dto);
         }

         @GetMapping("/{id}")
         public ResponseDto<UserDto> get(@PathVariable("id") Integer userId) {
                  return this.userService.getById(userId);
         }

         @PutMapping("/{id}")
         public ResponseDto<UserDto> update(@RequestBody UserDto dto,
                                            @PathVariable("id") Integer userId) {
                  return this.userService.update(dto, userId);
         }

         @DeleteMapping("/{id}")
         public ResponseDto<UserDto> delete(@PathVariable("id") Integer userId) {
                  return this.userService.delete(userId);
         }

         @GetMapping("/get")
         public ResponseDto<List<UserDto>> getAll() {
                  return this.userService.getAll();
         }

}


