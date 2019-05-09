package com.example.dao.impl;

import com.example.dao.ShopDao;
import com.example.eneity.TblSafetyWork;
import com.example.mapper.ShopMapper;
import com.example.more.DataSourceType;
import com.example.more.DatabaseContextHolder;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDaoImpl implements ShopDao {

    @Autowired
    private ShopMapper mapper;

    public TblSafetyWork getShop(int id) {
        DatabaseContextHolder.setDatabaseType(DataSourceType.mySql01);
        TblSafetyWork data = mapper.getShop(id);
        return data;
    }

}
