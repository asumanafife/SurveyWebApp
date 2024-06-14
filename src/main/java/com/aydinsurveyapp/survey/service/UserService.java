package com.aydinsurveyapp.survey.service;


import java.util.List;

import com.aydinsurveyapp.survey.dto.UserDTO;
import com.aydinsurveyapp.survey.dto.UserEditDTO;


public interface UserService {
    UserDTO create(UserEditDTO userEditDTO);

    UserDTO update(UserEditDTO userEditDTO, Integer userId);

    void delete(Integer userId);

    UserDTO getById(Integer userId);

    List<UserDTO> findAll();
}
