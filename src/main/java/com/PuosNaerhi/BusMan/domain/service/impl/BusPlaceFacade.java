package com.PuosNaerhi.BusMan.domain.service.impl;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;
import com.PuosNaerhi.BusMan.domain.entity.PlaceEntity;
import com.PuosNaerhi.BusMan.domain.service.BusService;
import com.PuosNaerhi.BusMan.domain.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Perttu Vanharanta on 6.10.2016.
 */
@Component
public class BusPlaceFacade {

    @Autowired
    BusService busService;

    @Autowired
    PlaceService placeService;


    public void createBusPlace(String startLocation, String endLocation, Integer busSize){
        BusEntity busEntity;
        String reserver = "";
        boolean reserved = false;

        busEntity = busService.createBus(startLocation, endLocation, busSize);
        for (int i = 1; i <= busSize; i++)
        {
            placeService.createPlace(busEntity,i,reserver,reserved);
        }
    }

    public void updateBusPlace(Integer id, String startLocation, String endLocation, Integer busSize){
        BusEntity busEntity = busService.readBus(id);
        String reserver = "";
        boolean reserved = false;

        Integer oldBusSize = busEntity.getBusSize();
        if(busSize != oldBusSize){
            List<PlaceEntity> oldPlaces = placeService.listPlace(busEntity);
            if(busSize < oldBusSize){
                for(int i = busSize; i < oldBusSize;i++){
                    PlaceEntity placeEntity = oldPlaces.get(i);
                    placeService.deletePlace(placeEntity.getId());
                }
            }else{
                for(int i = oldBusSize+1; i <= busSize; i++){
                    placeService.createPlace(busEntity,i,reserver,reserved);                }
            }

        }
        busService.updateBus(id, startLocation, endLocation, busSize);
    }

    public void deleteBusPlace(Integer id){
        BusEntity busEntity = busService.readBus(id);
        List<PlaceEntity> places = placeService.listPlace(busEntity);

        for(int i = 0; i < busEntity.getBusSize();i++){
            PlaceEntity placeEntity = places.get(i);
            placeService.deletePlace(placeEntity.getId());
        }
        busService.deleteBus(id);
    }

    public BusEntity readBus(Integer id){
        return busService.readBus(id);
    }

    public List<BusEntity> listBus(){
        return busService.listBus();
    }

    public List<PlaceEntity> listPlace(BusEntity busEntity){
        return placeService.listPlace(busEntity);
    }

    public void updatePlaceReserve(Integer id, Integer placeId, String reserver){
        BusEntity busEntity = busService.readBus(id);
        if(busEntity!= null){
            PlaceEntity placeEntity = placeService.readPlace(placeId);
            if(placeEntity != null){
                placeService.updatePlace(placeEntity.getId(),placeEntity.getPlaceNumber(),reserver,true);
            }
        }
    }

}
