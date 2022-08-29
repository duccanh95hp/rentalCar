package com.example.rentalcar.dto;

import com.example.rentalcar.model.SubscribersEntity;

import java.util.List;

public class listSb {
    private List<SubscribersEntity> data;
    public List<SubscribersEntity> getData(){
        return data;
    }
    public void setData(List<SubscribersEntity> data){
        this.data =data;
    }
}
