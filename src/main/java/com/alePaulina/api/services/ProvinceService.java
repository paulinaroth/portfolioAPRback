
package com.alePaulina.api.services;

import com.alePaulina.api.models.Province;
import com.alePaulina.api.repositories.ProvinceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pauline
 */
@Service
public class ProvinceService implements IProvinceService{
    
    @Autowired
    public ProvinceRepository provinceRepo;
    @Autowired 

    @Override
    public List<Province> getAllprovinces() {
        return provinceRepo.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepo.findById(id);
    }

    @Override
    public Province findByName(String name) {
        return provinceRepo.findByNameContaining(name);
    }

    @Override
    public String getName(Long id) {
        Optional<Province> province = this.provinceRepo.findById(id);
        Province foundProv = province.get();
        return foundProv.getName();
    }
    
}
