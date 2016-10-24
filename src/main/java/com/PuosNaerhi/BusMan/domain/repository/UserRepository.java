package com.PuosNaerhi.BusMan.domain.repository;


import com.PuosNaerhi.BusMan.domain.entity.UserEntity;

import java.util.List;

/**
 * Created by Perttu Vanharanta on 24.10.2016.
 */
public interface UserRepository {
    public void createUser(UserEntity userEntity);
    public UserEntity readUser(Integer id);
    public UserEntity getUser(String username);
    public void updateUser(UserEntity userEntity);
    public void deleteUser(Integer id);
    public List<UserEntity> listUser();
}
