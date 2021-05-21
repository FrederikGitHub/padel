package com.realdolmen.padel.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
//because group is a reserved word in mysql you have to prefix and suffix table name with \"
@Table(name = "\"group\"", schema = "padel")
public class GroupEntity {
    @Id
    @Column(name = "GROUP_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "GROUP_NAME")
    private String name;

    @Basic
    @Column(name = "GROUP_ACTIVE")
    private String active;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "group_vtv_level", joinColumns = {
            @JoinColumn(name = "GROUP_VTV_LEVEL_GROUP_ID")},
            inverseJoinColumns = {@JoinColumn(name = "GROUP_VTV_LEVEL_VTV_LEVEL_ID")})
    private Set<VtvLevelEntity> vtvLevels;

    public GroupEntity() {

    }

    public GroupEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Set<VtvLevelEntity> getVtvLevels() {
        return vtvLevels;
    }

    public void setVtvLevels(Set<VtvLevelEntity> vtvLevels) {
        this.vtvLevels = vtvLevels;
    }
}
