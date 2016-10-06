package com.PuosNaerhi.BusMan.domain.service;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;
import com.PuosNaerhi.BusMan.domain.entity.PlaceEntity;

import java.util.List;

/**
 * Created by Perttu Vanharanta on 6.10.2016.
 */
public interface PlaceService {

    public void createPlace(BusEntity busEntity, Integer placenumber, String reserver, boolean reserved);
    public PlaceEntity readPlace(Integer id);
    public void updatePlace(Integer id, Integer placenumber, String reserver, boolean reserved);
    public void deletePlace(Integer id);
    public List<PlaceEntity> listPlace(BusEntity busEntity);
}
