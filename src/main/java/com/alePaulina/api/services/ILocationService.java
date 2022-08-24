
package com.alePaulina.api.services;

import com.alePaulina.api.models.Location;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Pauline
 */
public interface ILocationService {
    public Optional<Location> findById(Long id);
    public List<Location> findAllByProvince(Long provinceId);
}
