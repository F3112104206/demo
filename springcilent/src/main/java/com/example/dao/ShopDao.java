package com.example.dao;

import com.example.eneity.TblSafetyWork;
import com.example.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public interface ShopDao {

    public TblSafetyWork getShop(int id);

}
