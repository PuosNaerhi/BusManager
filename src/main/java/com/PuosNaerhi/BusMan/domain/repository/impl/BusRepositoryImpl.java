package com.PuosNaerhi.BusMan.domain.repository.impl;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;
import com.PuosNaerhi.BusMan.domain.repository.BusRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Perttu Vanharanta on 5.10.2016.
 */
@Repository
public class BusRepositoryImpl implements BusRepository{


    @PersistenceContext
    EntityManager em;

    public void createBus(BusEntity busEntity) {
        em.persist(busEntity);
    }


    public BusEntity readBus(Integer id) {
        BusEntity busEntity = null;
        if(checkIsIdExist(id)){
            busEntity = em.find(BusEntity.class,id);
        }
        return busEntity;
    }


    public void updateBus(BusEntity busEntity) {
        em.merge(busEntity);
    }


    public void deleteBus(Integer id) {
        BusEntity busEntity = readBus(id);
        if(busEntity != null) {
            em.remove(busEntity);
        }
    }


    public List<BusEntity> listBus() {
        List<BusEntity> list =  em.createQuery("FROM BusEntity bus").getResultList();
        return list;
    }

    private boolean checkIsIdExist(Integer id){
        List<BusEntity> list = em.createQuery("FROM BusEntity bus WHERE bus.id=:id")
                .setParameter("id",id)
                .getResultList();
        if(!list.isEmpty())
        {
            return true;
        }
        return false;
    }
}
