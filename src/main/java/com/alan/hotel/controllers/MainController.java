package com.alan.hotel.controllers;

import com.alan.hotel.entities.Hotel;
import com.alan.hotel.repositories.HotelRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class MainController {

    @Autowired
    HotelRepository hotelRepository;

    @RequestMapping("/test")
    public String test() {
        return "funsiona";
    }

    @PostMapping("/new")
    public Long altaHotel(@RequestBody Hotel hotel){

        hotelRepository.save(hotel);

        return hotel.getId();
    }

    @PostMapping("/update")
    public Hotel updateHotel(@RequestBody Hotel hotel){

        if(hotel.getId() != null && hotelRepository.findOne(hotel.getId()) != null)
            hotelRepository.save(hotel);
        else return null;

        return hotel;
    }

    @RequestMapping("/delete/{id}")
    public Long deleteHotel(@PathVariable Long id){

        hotelRepository.delete(id);

        return id;
    }

    @RequestMapping("/get/{id}")
    public Hotel getHotel(@PathVariable Long id){

        if(id != null) return hotelRepository.findOne(id);
        else return null;
    }

    @RequestMapping("/findall")
    public List<Hotel> findAllHotel(){
        return hotelRepository.findAll();
    }
}
