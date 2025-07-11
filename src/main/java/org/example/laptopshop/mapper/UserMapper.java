package org.example.laptopshop.mapper;

import org.example.laptopshop.DTO.request.RegisterRequest;
import org.example.laptopshop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "fullName", expression =  "java(request.getFirstName() + \" \" + request.getLastName())")
    User toUser(RegisterRequest request);
}
