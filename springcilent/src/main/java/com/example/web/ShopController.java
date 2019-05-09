package com.example.web;


import com.example.eneity.TblSafetyWork;
import com.example.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {


    @Autowired
   private ShopService service;

   @RequestMapping(value = "/getShop", method = RequestMethod.GET)
    public TblSafetyWork getShop(@RequestParam("id") int id) {
              return service.getShop(id);
          }
}
