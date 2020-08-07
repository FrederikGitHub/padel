package com.realdolmen.padel.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GROUP", schema = "padel")
public class GroupEntity {
    @Id
    @Column(name = "GROUP_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "GROUP_NAME")
    private String name;

    @OneToMany(mappedBy="group")
    private Set<MemberEntity> members;

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

    public Set<MemberEntity> getMembers() {
        return members;
    }

    public void setMembers(Set<MemberEntity> members) {
        this.members = members;
    }
}
