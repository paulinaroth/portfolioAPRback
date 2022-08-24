
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
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Province implements Serializable {
    @Id
    private Long id;
    private String name;
    
    public Province() {
    }

    public Province(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
