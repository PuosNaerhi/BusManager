package com.PuosNaerhi.BusMan.domain.service.impl;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;
import com.PuosNaerhi.BusMan.domain.entity.PlaceEntity;
import com.PuosNaerhi.BusMan.domain.repository.BusRepository;
import com.PuosNaerhi.BusMan.domain.repository.PlaceRepository;
import com.PuosNaerhi.BusMan.domain.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Perttu Vanharanta on 5.10.2016.
 */
@Service
public class BusServiceImpl implements BusService{

    @Autowired
    BusRepository busRepository;

    @Autowired
    PlaceRepository placeRepository;


    @Transactional(readOnly = false)
    public BusEntity createBus(String startLocation, String endLocation, Integer busSize) {
        BusEntity busEntity = new BusEntity();
        busEntity.setStartLocation(startLocation);
        busEntity.setEndLocation(endLocation);
        busEntity.setBusSize(busSize);
        busRepository.createBus(busEntity);
        return busEntity;
    }

    @Transactional(readOnly = true)
    public BusEntity readBus(Integer id) {
        return busRepository.readBus(id);
    }

    @Transactional(readOnly = false)
    public void updateBus(Integer id,String startLocation, String endLocation, Integer busSize) {
        BusEntity busEntity = busRepository.readBus(id);
        busEntity.setStartLocation(startLocation);
        busEntity.setEndLocation(endLocation);
        busEntity.setBusSize(busSize);
        busRepository.updateBus(busEntity);
    }

    @Transactional(readOnly = false)
    public void deleteBus(Integer id) {
        busRepository.deleteBus(id);
    }

    @Transactional(readOnly = true)
    public List<BusEntity> listBus() {

        return busRepository.listBus();
    }
}
