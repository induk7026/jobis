package com.project.jobis.user.service;

import com.project.jobis.exception.CanNotRegisterUserException;
import com.project.jobis.exception.DuplicateUserEmailException;
import com.project.jobis.exception.EntityNotFoundException;
import com.project.jobis.exception.UserPasswordNotMatchException;
import com.project.jobis.user.controller.dto.UserLoginRequest;
import com.project.jobis.user.controller.dto.UserResponse;
import com.project.jobis.user.controller.dto.UserSignupRequest;
import com.project.jobis.user.domain.User;
import com.project.jobis.user.enums.RegistrableUser;
import com.project.jobis.user.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public User signupUser(UserSignupRequest userSignupRequest) {
        RegistrableUser registrableUser = RegistrableUser.find(userSignupRequest.getRegNo(), userSignupRequest.getName());
        if(registrableUser == RegistrableUser.UNKNOWN) {
            throw new CanNotRegisterUserException();
        }
        Optional<User> findUser = userRepository.findByUserNo(userSignupRequest.getUserId());
        if (findUser.isPresent()) {
            throw new DuplicateUserEmailException();
        }
        User user = User.builder()
            .userId(userSignupRequest.getUserId())
            .name(userSignupRequest.getName())
            .regNo(passwordEncoder.encode(userSignupRequest.getRegNo()))
            .password(passwordEncoder.encode(userSignupRequest.getPassword()))
            .createAt(LocalDateTime.now())
            .build();
        return userRepository.save(user);
    }

    public User authenticateByEmailAndPassword(UserLoginRequest userLoginRequest) {
        var user = userRepository.findByUserNo(userLoginRequest.getEmail())
            .orElseThrow(EntityNotFoundException::new);

        var match  = passwordEncoder.matches(userLoginRequest.getPassword(),user.getPassword());
        if(!match){
            throw new UserPasswordNotMatchException();
        }
        return user;
    }

    public UserResponse findUserById(Long id) {
        var user = userRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);
        return UserResponse.toEntity(user);
    }

    public void updateLastLoginAt(User user) {
        user.updateLastLoginAt();
        userRepository.save(user);
    }
}
