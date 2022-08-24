
package com.alePaulina.api.services;

import com.alePaulina.api.models.Location;
import com.alePaulina.api.repositories.LocationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pauline
 */
@Service
public class LocationService implements ILocationService {
    
    @Autowired
    public LocationRepository locatRepo;

    @Override
    public Optional<Location> findById(Long id) {
        return locatRepo.findById(id);
    }

    @Override
    public List<Location> findAllByProvince(Long provinceId) {
        List<Location> locationsRta = new ArrayList<>();
        List<Location> locations = locatRepo.findAll();
        for(int i=0; i<locations.size(); i++){
            if(locations.get(i).getProvinceId()==provinceId){
                locationsRta.add(locations.get(i));
            }
        }
        return locationsRta;
    }
    
}
