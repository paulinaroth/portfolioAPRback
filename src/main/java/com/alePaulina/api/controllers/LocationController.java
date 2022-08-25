
package com.alePaulina.api.controllers;

import com.alePaulina.api.exception.NotFoundException;
import com.alePaulina.api.models.Location;
import com.alePaulina.api.services.ILocationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pauline
 */

@RestController
public class LocationController {
    @Autowired
    private ILocationService locationServ;
    
    @GetMapping("/location/search/{id}")   
    public ResponseEntity<Optional<Location>> findById(@PathVariable Long id)throws Exception {
        Optional<Location> location = locationServ.findById(id);
        if(location.isEmpty()){
            throw new NotFoundException("La localidad que busca no se encuentra en la base de datos.");
        }
        return new ResponseEntity<>(locationServ.findById(id), HttpStatus.OK);
    }
    
    @GetMapping("/location/byProvince/{provinceId}") 
    public ResponseEntity<List<Location>> findAllByProvince(@PathVariable Long provinceId) {
        return new ResponseEntity(locationServ.findAllByProvince(provinceId), HttpStatus.OK);
        
    }
    
}
