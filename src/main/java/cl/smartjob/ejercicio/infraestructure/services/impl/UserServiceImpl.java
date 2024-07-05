package cl.smartjob.ejercicio.infraestructure.services.impl;

import cl.smartjob.ejercicio.api.dto.mappers.PhoneMapper;
import cl.smartjob.ejercicio.api.dto.mappers.UserMapper;
import cl.smartjob.ejercicio.api.dto.requests.UserRequest;
import cl.smartjob.ejercicio.api.dto.responses.AuthResponse;
import cl.smartjob.ejercicio.api.dto.responses.UserResponse;
import cl.smartjob.ejercicio.exception.NotFoundException;
import cl.smartjob.ejercicio.util.jwt.JwtService;
import cl.smartjob.ejercicio.domain.repositories.UserRepository;
import cl.smartjob.ejercicio.infraestructure.services.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final PhoneMapper phoneMapper;

    @Override
    public List<UserResponse> findAll() {
        var users = this.userRepository.findAll().stream().map(this.userMapper::entityToResponse).toList();
        return users;
    }

    @Override
    public AuthResponse register(UserRequest userRequest) {
        var user = userMapper.requestToEntity(userRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setLastLogin(LocalDateTime.now());
        var phones = userRequest.getPhones().stream().map(this.phoneMapper::requestToEntity).collect(Collectors.toSet());
        phones.forEach(p -> p.setUser(user));
        user.setPhones(phones);
        var userToPersist = userRepository.saveAndFlush(user);
        var token = jwtService.getToken(userToPersist);
        log.info("Generate JWT successfully");
        var resp = this.userMapper.entityToAuthResponse(userToPersist);
        resp.setToken(token);
        return resp;
    }

    @Override
    public UserResponse created(UserRequest userRequest) {
        var user = userMapper.requestToEntity(userRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var userToPersist = userRepository.saveAndFlush(user);
        return this.userMapper.entityToResponse(userToPersist);
    }

    @Override
    public UserResponse show(UUID id) {
        var user = this.userRepository.findById(id).orElseThrow();
        log.info("User show with id {}", user.getId());
        var usersResponse = this.userMapper.entityToResponse(user);
        var phonesResponse = user.getPhones().stream().map(this.phoneMapper::entityToResponse).toList();
        usersResponse.setPhones(phonesResponse);
        return usersResponse;
    }

    @Override
    public void delete(UUID id) {
        var user = this.userRepository.findById(id).orElseThrow(() -> new NotFoundException("users"));
        log.warn("User delete with id {}", user.getId());
        this.userRepository.delete(user);
    }

}
