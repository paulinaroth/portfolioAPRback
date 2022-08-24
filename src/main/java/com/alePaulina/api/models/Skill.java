
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


// @author Pauline
@Getter @Setter
@Entity
public class Skill implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Basic
    private String name;
    private String icon;
    
    //FK
    @JoinColumn(name="pers", updatable = false, nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Person pers;
    
    

    public Skill() {
    }

    public Skill(Long id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }
    public void setPers(Person person){
        this.pers = person;
    }
}
