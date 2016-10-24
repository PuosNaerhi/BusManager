package com.PuosNaerhi.BusMan.domain.repository.impl;

import com.PuosNaerhi.BusMan.domain.entity.UserEntity;
import com.PuosNaerhi.BusMan.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Perttu Vanharanta on 24.10.2016.
 */
@Repository
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    EntityManager em;


    public void createUser(UserEntity userEntity) {
        em.persist(userEntity);
    }


    public UserEntity readUser(Integer id) {
        UserEntity userEntity = null;
        if(checkIsIdExist(id)){
            userEntity = em.find(UserEntity.class,id);
        }
        return userEntity;
    }

    public UserEntity getUser(String username) {
        return em.createQuery("FROM UserEntity u WHERE u.username=:username", UserEntity.class)
                .setParameter("username", username)
                .getSingleResult();
    }


    public void updateUser(UserEntity userEntity) {
        em.merge(userEntity);
    }


    public void deleteUser(Integer id) {
        UserEntity userEntity = readUser(id);
        if(userEntity != null) {
            em.remove(userEntity);
        }
    }


    public List<UserEntity> listUser() {
        List<UserEntity> list = em.createQuery("FROM UserEntity user")
                .getResultList();
        return list;
    }


    private boolean checkIsIdExist(Integer id){
        List<UserEntity> list = em.createQuery("FROM UserEntity user WHERE user.id=:id")
                .setParameter("id",id)
                .getResultList();
        if(!list.isEmpty())
        {
            return true;
        }
        return false;
    }
}
