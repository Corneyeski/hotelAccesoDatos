package com.alan.hotel.controllers;

import com.alan.hotel.entities.Hotel;
import com.alan.hotel.repositories.HotelRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MainController {

    @Autowired
    HotelRepository hotelRepository;

    @RequestMapping("/test")
    public String test() {
        return "funsiona";
    }

    @RequestMapping("/new")
    public Hotel altHotel(@RequestBody Hotel hotel){

        hotelRepository.save(hotel);

        return hotel;
    }
}
