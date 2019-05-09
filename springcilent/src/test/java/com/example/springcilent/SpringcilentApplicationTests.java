package com.example.springcilent;

import com.example.dao.ShopDao;
import com.example.eneity.TblSafetyWork;
import com.example.mapper.ShopMapper;
import com.example.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcilentApplicationTests {

    @Autowired
    ShopDao shopService;
    @Test
    public void contextLoads() {

        TblSafetyWork t=shopService.getShop(1);
        System.out.printf("*********");
    }

}
