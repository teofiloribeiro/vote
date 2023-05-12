package com.teofilo.vote.services.impl;

import com.teofilo.vote.dto.UserDto;
import com.teofilo.vote.entities.User;
import com.teofilo.vote.exceptions.DataNotFoundException;
import com.teofilo.vote.repositories.IUserRepository;
import com.teofilo.vote.services.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDto update (Long id, UserDto userDto) throws DataNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User Not Found."));
        userDto.setId(id);
        User userToUpdate = this.userConverter(userDto);
        userRepository.save(userToUpdate);
        return userConverter(userToUpdate);
    }

    public UserDto insert (UserDto userDto){
        userDto.setId(null);
        User user = this.userConverter(userDto);
        userRepository.save(user);
        return userConverter(user);
    }

    public List<UserDto> findAll(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::userConverter)
                .collect(Collectors.toList());
    }

    public UserDto findById(Long id) throws DataNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User Not Found."));
        return this.userConverter(user);
    }

    private User userConverter (UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }

    private UserDto userConverter (User user){
        return modelMapper.map(user, UserDto.class);
    }
}
