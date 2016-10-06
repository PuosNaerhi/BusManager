package com.PuosNaerhi.BusMan.domain.repository;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;

import java.util.List;

/**
 * Created by Perttu Vanharanta on 5.10.2016.
 */
public interface BusRepository {

    public void createBus(BusEntity busEntity);
    public BusEntity readBus(Integer id);
    public void updateBus(BusEntity busEntity);
    public void deleteBus(Integer id);
    public List<BusEntity> listBus();
}
