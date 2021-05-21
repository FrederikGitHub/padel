package com.realdolmen.padel.model;

import com.realdolmen.padel.entity.VtvLevelEntity;

import java.util.function.Function;

public class VtvLevel {

    private long id;
    private String name;

    public VtvLevel() {

    }

    public VtvLevel(long id, String name) {
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

    public static class Functions {

        public static Function<VtvLevelEntity, VtvLevel> FROM_VTV_LEVEL_ENTITY = new Function<VtvLevelEntity, VtvLevel>() {
            @Override
            public VtvLevel apply(VtvLevelEntity vtvLevelEntity) {
                VtvLevel vtvLevel = new VtvLevel();
                vtvLevel.setId(vtvLevelEntity.getId());
                vtvLevel.setName(vtvLevelEntity.getName());
                return vtvLevel;
            }
        };

        public static Function<VtvLevel, VtvLevelEntity> TO_VTV_LEVEL_ENTITY = new Function<VtvLevel, VtvLevelEntity>() {
            @Override
            public VtvLevelEntity apply(VtvLevel vtvLevel) {
                VtvLevelEntity vtvLevelEntity = new VtvLevelEntity();
                vtvLevelEntity.setId(vtvLevel.getId());
                vtvLevelEntity.setName(vtvLevel.getName());
                return vtvLevelEntity;
            }
        };



    }
}
