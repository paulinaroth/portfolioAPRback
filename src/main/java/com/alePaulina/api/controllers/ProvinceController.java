
package com.alePaulina.api.controllers;

import com.alePaulina.api.exception.NotFoundException;
import com.alePaulina.api.models.Province;
import com.alePaulina.api.services.IProvinceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Pauline
 */
@CrossOrigin(origins = "*")
@Controller
public class ProvinceController {
    @Autowired
    private IProvinceService provinceServ;
    
    @GetMapping("/provinces")
    public ResponseEntity<List<Province>> getAllprovinces(){
        return new ResponseEntity<> (provinceServ.getAllprovinces(), HttpStatus.OK);
    }
    
    @GetMapping("/province/search/{id}")
    public ResponseEntity<Optional<Province>> findById(@PathVariable Long id) throws Exception{
        Optional <Province> province = provinceServ.findById(id);
        if (province.isEmpty()){
            throw new NotFoundException("La provincia que busca no se encuentra en la base de datos.");
        }
        return new ResponseEntity<> (provinceServ.findById(id), HttpStatus.OK);
    }
    
    @GetMapping("/province/searchByName/{name}")
    public ResponseEntity<Province> findByName(@PathVariable String name) {
        return new ResponseEntity<Province> (provinceServ.findByName(name), HttpStatus.OK);
    }
    
    
    @GetMapping("province/{id}/name")
    public String getName(@PathVariable Long id){
        Optional <Province> province = provinceServ.findById(id);
        if (province.isEmpty()){
            throw new NotFoundException("La provincia que busca no se encuentra en la base de datos.");
        }
        return provinceServ.getName(id);
    }
}
