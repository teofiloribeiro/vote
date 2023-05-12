package com.teofilo.vote.services;

import com.teofilo.vote.dto.UserDto;
import com.teofilo.vote.exceptions.DataNotFoundException;

import java.util.List;

public interface IUserService {
    UserDto update (Long id, UserDto userDto) throws DataNotFoundException;
    UserDto insert (UserDto userDto);
    List<UserDto> findAll();
    UserDto findById(Long id) throws DataNotFoundException;
}
