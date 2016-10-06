package com.PuosNaerhi.BusMan.domain.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Perttu Vanharanta on 5.10.2016.
 */

@Entity
public class BusEntity {

    @GeneratedValue
    @Id
    Integer id;

    String startLocation;
    String endLocation;
    Integer busSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public Integer getBusSize() {
        return busSize;
    }

    public void setBusSize(Integer busSize) {
        this.busSize = busSize;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }
}
