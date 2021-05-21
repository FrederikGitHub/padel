package com.realdolmen.padel.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vtv_level", schema = "padel")
public class VtvLevelEntity {

    @Id
    @Column(name = "vtv_level_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "vtv_level_name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "group_vtv_level", joinColumns = {
            @JoinColumn(name = "GROUP_VTV_LEVEL_VTV_LEVEL_ID")},
            inverseJoinColumns = {@JoinColumn(name = "GROUP_VTV_LEVEL_GROUP_ID")})
    private Set<GroupEntity> groups;

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

    public Set<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
    }
}
