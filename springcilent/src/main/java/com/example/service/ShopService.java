package com.example.service;


import com.example.dao.ShopDao;
import com.example.eneity.TblSafetyWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    private ShopDao dao;


    public TblSafetyWork getShop(int id){
        return dao.getShop(id);
    }
}
