package com.example.springbootactions.service.mapper;

import com.example.springbootactions.dto.UserDto;
import com.example.springbootactions.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

         @Mapping(target = "userId", ignore = true)
         @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
         @Mapping(target = "updatedAt", ignore = true)
         @Mapping(target = "deletedAt", ignore = true)
         public abstract User toEntity(UserDto dto);

         @Mapping(target = "userId", ignore = true)
         @Mapping(target = "createdAt", ignore = true)
         @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
         @Mapping(target = "deletedAt", ignore = true)
         @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
         public abstract void update(@MappingTarget User users, UserDto dto);

         @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd")
         @Mapping(target = "updatedAt", dateFormat = "yyyy-MM-dd")
         @Mapping(target = "deletedAt", dateFormat = "yyyy-MM-dd")
         public abstract UserDto toDto(User users);
}



