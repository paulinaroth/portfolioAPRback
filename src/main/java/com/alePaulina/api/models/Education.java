
package com.alePaulina.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
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
@Getter @Setter
@Entity
public class Education implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Basic
    private String school;
    private String title;
    private String logo;
    private String description;
    private String site;
    private int start_year;
    private int ending_year;
    
     //FK
    @JoinColumn(name="pers", updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Person pers;

    public Education() {
    }

    public Education(Long id, String school, String title, String logo, String description, String site, int start_year, int ending_year) {
        this.id = id;
        this.school = school;
        this.title = title;
        this.logo = logo;
        this.description = description;
        this.site = site;
        this.start_year = start_year;
        this.ending_year = ending_year;
    }
    
}
