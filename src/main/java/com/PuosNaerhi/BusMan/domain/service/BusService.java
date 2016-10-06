package com.PuosNaerhi.BusMan.domain.service;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;

import java.util.List;

/**
 * Created by Perttu Vanharanta on 5.10.2016.
 */
public interface BusService {

    public BusEntity createBus(String startLocation, String endLocation, Integer busSize);
    public BusEntity readBus(Integer id);
    public void updateBus(Integer id,String startLocation, String endLocation, Integer busSize);
    public void deleteBus(Integer id);
    public List<BusEntity> listBus();
}
