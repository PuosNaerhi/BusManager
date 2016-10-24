package com.PuosNaerhi.BusMan.domain.service;

import com.PuosNaerhi.BusMan.web.WwwUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Perttu Vanharanta on 24.10.2016.
 */
public interface UserService extends UserDetailsService{

    public void createUser(WwwUser wwwUser);

    public String isFirstUser();
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
