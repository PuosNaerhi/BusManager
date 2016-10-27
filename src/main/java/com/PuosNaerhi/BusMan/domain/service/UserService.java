package com.PuosNaerhi.BusMan.domain.service;

import com.PuosNaerhi.BusMan.domain.entity.UserEntity;
import com.PuosNaerhi.BusMan.web.WwwUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by Perttu Vanharanta on 24.10.2016.
 */
public interface UserService extends UserDetailsService{

    public void createUser(WwwUser wwwUser);
    public WwwUser getUser(String username);
    public WwwUser getUserById(Integer id);
    public UserEntity getUserEntity(String username);
    public void updateUser(Integer id, String username, String email);
    public void deleteUser(Integer id);
    public List<UserEntity> getUserList();
    public String isFirstUser();
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
