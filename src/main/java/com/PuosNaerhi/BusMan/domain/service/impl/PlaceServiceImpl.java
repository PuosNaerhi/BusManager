package com.PuosNaerhi.BusMan.domain.service.impl;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;
import com.PuosNaerhi.BusMan.domain.entity.PlaceEntity;
import com.PuosNaerhi.BusMan.domain.repository.PlaceRepository;
import com.PuosNaerhi.BusMan.domain.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Perttu Vanharanta on 6.10.2016.
 */
@Service
public class PlaceServiceImpl implements PlaceService{

    @Autowired
    PlaceRepository placeRepository;

    @Transactional(readOnly = false)
    public void createPlace(BusEntity busEntity, Integer placenumber, String reserver, boolean reserved) {
        PlaceEntity placeEntity = new PlaceEntity();
        placeEntity.setBusEntity(busEntity);
        placeEntity.setPlaceNumber(placenumber);
        placeEntity.setReservationMaker(reserver);
        placeEntity.setReserved(reserved);
        placeRepository.createPlace(placeEntity);
    }

    @Transactional(readOnly = true)
    public PlaceEntity readPlace(Integer id) {
        return placeRepository.readPlace(id);
    }

    @Transactional(readOnly = false)
    public void updatePlace(Integer id, Integer placenumber, String reserver, boolean reserved) {
        PlaceEntity placeEntity = placeRepository.readPlace(id);
        placeEntity.setPlaceNumber(placenumber);
        placeEntity.setReservationMaker(reserver);
        placeEntity.setReserved(reserved);
        placeRepository.updatePlace(placeEntity);
    }

    @Transactional(readOnly = false)
    public void deletePlace(Integer id) {
        placeRepository.deletePlace(id);
    }

    @Transactional(readOnly = true)
    public List<PlaceEntity> listPlace(BusEntity busEntity) {
        return placeRepository.listPlace(busEntity);
    }

    @Transactional(readOnly = true)
    public List<PlaceEntity> listUserPlaces(String reservationMaker) {
        return placeRepository.listUserPlaces(reservationMaker);
    }

}
