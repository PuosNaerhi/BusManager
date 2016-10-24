package com.PuosNaerhi.BusMan.domain.service.impl;

import com.PuosNaerhi.BusMan.domain.entity.UserEntity;
import com.PuosNaerhi.BusMan.domain.repository.UserRepository;
import com.PuosNaerhi.BusMan.domain.service.UserService;
import com.PuosNaerhi.BusMan.web.WwwUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Perttu Vanharanta on 24.10.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional(readOnly = false)
    public void createUser(WwwUser wwwUser) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(wwwUser.getEmail());
        userEntity.setPassword(passwordEncoder.encode(wwwUser.getPassword()));
        userEntity.setRole(wwwUser.getRole());
        userEntity.setUsername(wwwUser.getUsername());
        userRepository.createUser(userEntity);
    }

    @Transactional(readOnly = true)
    public String isFirstUser(){
        String role = "ROLE_USER";
        List<UserEntity> list = userRepository.listUser();
        if(list.isEmpty()){
            role = "ROLE_ADMIN";
        }
        return role;
    }

    @Transactional(readOnly = true)
    public WwwUser getUser(String username) {
        UserEntity u = userRepository.getUser(username);
        return new WwwUser(u.getUsername(), u.getPassword(),u.getEmail(),u.getRole());
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUser(username);
    }
}
