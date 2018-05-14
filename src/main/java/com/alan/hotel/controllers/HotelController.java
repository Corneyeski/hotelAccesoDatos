package com.alan.hotel.controllers;

import com.alan.hotel.entities.Hotel;
import com.alan.hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.BadRequestException;
import java.util.List;

@RestController("/")
public class HotelController {

    @Autowired
    HotelRepository hotelRepository;

    @RequestMapping("/test")
    public String test() {
        return "funsiona";
    }

    @PostMapping("/hotels")
    public Hotel createHotel(@RequestBody Hotel hotel) {

        hotelRepository.save(hotel);

        return hotel;
    }

    @PutMapping("/hotels")
    public Hotel updateHotel(@RequestBody Hotel hotel) {

        if (hotel.getId() == null) {
            throw new BadRequestException("A hotel needs a valid ID");
        }

        return hotelRepository.save(hotel);
    }

    @DeleteMapping("/hotels/{id}")
    public Long deleteHotel(@PathVariable Long id) {

        hotelRepository.delete(id);

        return id;
    }

    @RequestMapping("/hotels/{id}")
    public Hotel getHotel(@PathVariable Long id) {

        if (id != null) return hotelRepository.findOne(id);
        else throw new BadRequestException("Not hotel found with ID");
    }

    @GetMapping("/hotels")
    public List<Hotel> findAllHotel() {
        return hotelRepository.findAll();
    }
}
