package com.PuosNaerhi.BusMan.domain.service;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;
import com.PuosNaerhi.BusMan.domain.entity.PlaceEntity;
import com.PuosNaerhi.BusMan.domain.entity.UserEntity;

import java.util.List;

/**
 * Created by Perttu Vanharanta on 6.10.2016.
 */
public interface PlaceService {

    public void createPlace(BusEntity busEntity, Integer placenumber, boolean reserved);
    public PlaceEntity readPlace(Integer id);
    public void updatePlace(Integer id, Integer placenumber, UserEntity userEntity, boolean reserved);
    public void deletePlace(Integer id);
    public List<PlaceEntity> listPlace(BusEntity busEntity);
    public List<PlaceEntity> listUserPlaces(UserEntity userEntity);
}
