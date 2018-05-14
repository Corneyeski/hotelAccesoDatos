package com.alan.hotel.controllers;

import com.alan.hotel.entities.Hotel;
import com.alan.hotel.repositories.HotelRepository;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.BadRequestException;
import java.util.List;

@RestController("/")
public class HotelController {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    HotelRepository hotelRepository;

    @PostMapping("/hotels")
    public Hotel createHotel(@RequestBody Hotel hotel) {

        log.debug("Creating Hotel {}" , hotel);

        hotelRepository.save(hotel);

        return hotel;
    }

    @PutMapping("/hotels")
    public Hotel updateHotel(@RequestBody Hotel hotel) {

        log.debug("Update Hotel {}" , hotel);

        if (hotel.getId() == null) {
            throw new BadRequestException("A hotel needs a valid ID");
        }

        return hotelRepository.save(hotel);
    }

    @DeleteMapping("/hotels/{id}")
    public Long deleteHotel(@PathVariable Long id) {

        log.debug("Delete Hotel with ID{}" , id);

        hotelRepository.delete(id);

        return id;
    }

    @GetMapping("/hotels/{id}")
    public Hotel getHotel(@PathVariable Long id) {

        log.debug("Get Hotel with ID {}" , id);

        if (id != null) return hotelRepository.findOne(id);
        else throw new BadRequestException("Not hotel found with ID");
    }

    @GetMapping("/hotels")
    public List<Hotel> findAllHotel() {

        log.debug("Find hotels");

        return hotelRepository.findAll();
    }
}
