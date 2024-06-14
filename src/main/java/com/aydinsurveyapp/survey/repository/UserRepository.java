package com.aydinsurveyapp.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aydinsurveyapp.survey.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(Integer id);
}
