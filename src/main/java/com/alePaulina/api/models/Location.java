
package com.alePaulina.api.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pauline
 */
@Getter @Setter
@Entity
public class Location implements Serializable{
    @Id
    private Long id;
    private Long provinceId;
    private String name;
    
    public Location() {
    }

    public Location(Long id, Long provinceId, String name) {
        this.id = id;
        this.provinceId = provinceId;
        this.name = name;
    }
    
}
