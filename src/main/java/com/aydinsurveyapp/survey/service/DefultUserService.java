package com.aydinsurveyapp.survey.service;
import org.springframework.stereotype.Service;
import com.aydinsurveyapp.survey.dto.UserDTO;
import com.aydinsurveyapp.survey.dto.UserEditDTO;
import com.aydinsurveyapp.survey.exception.BadRequestException;
import com.aydinsurveyapp.survey.exception.NotFoundException;
import com.aydinsurveyapp.survey.model.User;
import com.aydinsurveyapp.survey.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefultUserService implements UserService {

    private UserRepository userRepository;

    public DefultUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO create(UserEditDTO userEditDTO) {
        if(userEditDTO == null || userEditDTO.getUsername() == null || userEditDTO.getPassword() == null) {
            throw new BadRequestException("Username and password must be provided");
        }
        User user = userEditDTOtoUser(userEditDTO);
        user = userRepository.save(user);
        return UserToUserDTO(user);
    }

    @Override
    public UserDTO update(UserEditDTO userEditDTO, Integer userId) {
        User user = userRepository.findByUserId(userId);
        if(user == null) {
            throw new NotFoundException("User not found");
        }
        if(userEditDTO == null || userEditDTO.getUsername() == null) {
            throw new BadRequestException("Username must be provided for update");
        }
        user.setUsername(userEditDTO.getUsername());
        userRepository.save(user);
        return UserToUserDTO(user);
    }

    @Override
    public void delete(Integer userId) {
        User user = userRepository.findByUserId(userId);
        if(user == null) {
            throw new NotFoundException("User not found");
        }
        userRepository.deleteById(userId);
    }

    @Override
    public UserDTO getById(Integer userId) {
        User user = userRepository.findByUserId(userId);
        if(user == null) {
            throw new NotFoundException("User not found");
        }
        return UserToUserDTO(user);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        for(User user: users){
            userDTOs.add(UserToUserDTO(user));
        }
        return userDTOs;
    }

    private User userEditDTOtoUser(UserEditDTO userEditDTO){
        return User.builder().username(userEditDTO.getUsername()).password(userEditDTO.getPassword()).build();
    }

    private UserDTO UserToUserDTO(User user) {
        return UserDTO.builder().username(user.getUsername()).userId(user.getUserId()).build();
    }

}
