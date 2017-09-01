package com.boot.controller;
import java.util.List;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Prabhas_Harlapur on 8/29/2017.
 */

@RestController
@RequestMapping("api/v1")
public class ShipwreckController {


    @Autowired
    private ShipwreckRepository shipwreckRepository;

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list() {
        return shipwreckRepository.findAll();
    }

    @RequestMapping(value = "shipwrecks", method =  RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {


        return shipwreckRepository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable Long id) {

        return shipwreckRepository.findOne(id);

    }

    @RequestMapping(value = "shipwrecks/{id}", method =  RequestMethod.PUT)
    public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck){

        Shipwreck existingShipWreck = shipwreckRepository.findOne(id);
        BeanUtils.copyProperties(shipwreck,existingShipWreck);
        return shipwreckRepository.saveAndFlush(shipwreck);

    }

    @RequestMapping(value = "shipwrecks/id", method = RequestMethod.DELETE)
    public Shipwreck delete (@PathVariable Long id){

        Shipwreck existingShipWreck = shipwreckRepository.findOne(id);
        shipwreckRepository.delete(existingShipWreck);
        return existingShipWreck;

    }


}



