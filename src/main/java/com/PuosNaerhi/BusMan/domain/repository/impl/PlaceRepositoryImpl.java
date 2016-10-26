package com.PuosNaerhi.BusMan.domain.repository.impl;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;
import com.PuosNaerhi.BusMan.domain.entity.PlaceEntity;
import com.PuosNaerhi.BusMan.domain.repository.PlaceRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Perttu Vanharanta on 5.10.2016.
 */
@Repository
public class PlaceRepositoryImpl implements PlaceRepository{

    @PersistenceContext
    EntityManager em;

    public void createPlace(PlaceEntity placeEntity) {
        em.persist(placeEntity);
    }


    public PlaceEntity readPlace(Integer id) {
        PlaceEntity placeEntity = null;
        if(checkIsIdExist(id)){
            placeEntity = em.find(PlaceEntity.class,id);
        }
        return placeEntity;

    }

    public void updatePlace(PlaceEntity placeEntity) {
        em.merge(placeEntity);
    }

    public void deletePlace(Integer id) {
        PlaceEntity placeEntity = readPlace(id);
        if(placeEntity != null) {
            em.remove(placeEntity);
        }
    }


    public List<PlaceEntity> listPlace(BusEntity busEntity) {
        List<PlaceEntity> list = em.createQuery("FROM PlaceEntity place WHERE place.busEntity=:busEntity")
                .setParameter("busEntity",busEntity)
                .getResultList();
        return list;
    }


    public List<PlaceEntity> listUserPlaces(String reservationMaker) {
        List<PlaceEntity> list = em.createQuery("FROM PlaceEntity place WHERE place.reservationMaker=:reservationMaker")
                .setParameter("reservationMaker",reservationMaker)
                .getResultList();
        return list;
    }

    private boolean checkIsIdExist(Integer id){
        List<PlaceEntity> list = em.createQuery("FROM PlaceEntity place WHERE place.id=:id")
                .setParameter("id",id)
                .getResultList();
        if(!list.isEmpty())
        {
            return true;
        }
        return false;
    }
}
