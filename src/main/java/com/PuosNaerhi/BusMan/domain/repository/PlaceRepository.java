package com.PuosNaerhi.BusMan.domain.repository;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;
import com.PuosNaerhi.BusMan.domain.entity.PlaceEntity;

import java.util.List;

/**
 * Created by Perttu Vanharanta on 5.10.2016.
 */
public interface PlaceRepository {
    public void createPlace(PlaceEntity placeEntity);
    public PlaceEntity readPlace(Integer id);
    public void updatePlace(PlaceEntity placeEntity);
    public void deletePlace(Integer id);
    public List<PlaceEntity> listPlace(BusEntity busEntity);
}
