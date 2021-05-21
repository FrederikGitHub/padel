package com.realdolmen.padel.dao;

import com.realdolmen.padel.entity.MemberEntity;

import java.util.List;


public interface MemberDao {
    void save(MemberEntity memberEntity);

    void delete(MemberEntity memberEntity);

    List<MemberEntity> getMemberList();

    MemberEntity findMemberById(Long id);


}
