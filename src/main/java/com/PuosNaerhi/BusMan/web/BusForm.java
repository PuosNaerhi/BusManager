package com.PuosNaerhi.BusMan.web;

/**
 * Created by Perttu Vanharanta on 5.10.2016.
 */
public class BusForm {

    String startLocation;
    String endLocation;
    Integer busSize;

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Integer getBusSize() {
        return busSize;
    }

    public void setBusSize(Integer busSize) {
        this.busSize = busSize;
    }
}
