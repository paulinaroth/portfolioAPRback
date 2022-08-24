
package com.alePaulina.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pauline
 */
@Entity
@Getter @Setter
public class Project implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String image;
    @Column(name="description", length=1000)
    private String description;
    private int ryear;
    private String site;
    
    //FK
    @JoinColumn(name="pers", updatable = false, nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Person pers;

    public Project() {
    }

    public Project(Long id, String name, String image, String description, int ryear, String site) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.ryear = ryear;
        this.site = site;
    }
   
}
