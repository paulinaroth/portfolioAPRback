
package com.alePaulina.api.models;

/**
 *
 * @author Pauline
 */

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Basic
    private String name;
    private String title;
    @Column(name="about", length=1000)
    private String about;
    private String profileimg;
    private String email;
    
    
//relations
    @JoinColumn(name="provinceId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Province province;
    
    @JoinColumn(name="locationId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Location location;
   
    @OneToMany(mappedBy = "pers")
    private List<Skill> skills;
    
    @OneToMany(mappedBy = "pers")
    private List<Education> education;
    
    @OneToMany(mappedBy = "pers")
    private List<Project> projects;
    

    //Constructors
    public Person() {
    }

    public Person(Long id, String name, String title, String about, String profileimg, String email, Province province, Location location) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.about = about;
        this.profileimg = profileimg;
        this.email = email;
        this.province = province;
        this.location = location;
    }

}
