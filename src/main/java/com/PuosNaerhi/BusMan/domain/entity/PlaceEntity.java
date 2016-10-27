package com.PuosNaerhi.BusMan.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Perttu Vanharanta on 5.10.2016.
 */
@Entity
public class PlaceEntity {

    @GeneratedValue
    @Id
    Integer id;

    @ManyToOne
    BusEntity busEntity;

    Integer placeNumber;
    boolean reserved = false;

    @ManyToOne
    UserEntity userEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlaceNumber() {
        return placeNumber;
    }

    public BusEntity getBusEntity() {
        return busEntity;
    }

    public void setBusEntity(BusEntity busEntity) {
        this.busEntity = busEntity;
    }

    public void setPlaceNumber(Integer placeNumber) {
        this.placeNumber = placeNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
