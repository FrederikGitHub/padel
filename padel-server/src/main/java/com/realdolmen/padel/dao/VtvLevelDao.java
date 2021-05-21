package com.realdolmen.padel.dao;

import com.realdolmen.padel.entity.VtvLevelEntity;

import java.util.List;

public interface VtvLevelDao {
    void save(VtvLevelEntity vtvLevelEntity);

    void delete(VtvLevelEntity vtvLevelEntity);

    List<VtvLevelEntity> getVtvLevelList();
}
