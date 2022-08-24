
package com.alePaulina.api.services;

import com.alePaulina.api.models.Province;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Pauline
 */
public interface IProvinceService {
    public List<Province> getAllprovinces();
    public Optional<Province> findById(Long id);
    public Province findByName(String name);
    public String getName(Long id);
}
