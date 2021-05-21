package com.realdolmen.padel.model;

import com.realdolmen.padel.entity.GroupEntity;
import com.realdolmen.padel.entity.VtvLevelEntity;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Group implements Comparable<Group> {
    private Long id;
    private String name;
    private String active;
    private List<VtvLevel> vtvLevels;

    public Group() {

    }

    public Group(long id, String name, List<VtvLevel> vtvLevels, String active) {
        this.id = id;
        this.name = name;
        this.vtvLevels = vtvLevels;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public Group setId(long id) {
        this.id = id;
        return this;
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

    public Group setActive(String active) {
        this.active = active;
        return this;
    }

    public Group setVtvLevel(List<VtvLevel> vtvLevels) {
        this.vtvLevels = vtvLevels;
        return this;
    }


    public List<VtvLevel> getVtvLevels() {
        return vtvLevels;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                "name=" + name +
                "vtvLevel=" + vtvLevels +
                "active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Group o) {
        return this.id.compareTo(o.id);
    }


    public static class Predicates {

        public static final Predicate<Group> withGroupName(final String groupName) {
            return new Predicate<Group>() {
                @Override
                public boolean test(Group group) {
                    return group.getName() != null && group.getName().equalsIgnoreCase(groupName);
                }
            };
        }

        public static final Predicate<Group> withGroupLevel(final String vtvLevel) {
            return new Predicate<Group>() {
                @Override
                public boolean test(Group group) {
                    return group.getVtvLevels() != null && group.getVtvLevels().contains(vtvLevel);
                }
            };
        }

        public static final Predicate<Group> IS_ACTIVE = new Predicate<Group>() {
            @Override
            public boolean test(Group group) {
                return group.getActive() == null || group.getActive().equalsIgnoreCase("Y");
            }
        };

    }

    public static class Functions {

        public static Function<Group, String> TO_GROUP_NAME = new Function<Group, String>() {
            @Override
            public String apply(Group group) {
                return group.getName();
            }
        };

        public static Function<GroupEntity, Group> FROM_GROUP_ENTITY = new Function<GroupEntity, Group>() {
            @Override
            public Group apply(GroupEntity groupEntity) {
                Group group = new Group();
                group.setId(groupEntity.getId());
                group.setName(groupEntity.getName());
                if (!CollectionUtils.isEmpty(groupEntity.getVtvLevels())) {
                    List<VtvLevel> vtvLevelList = groupEntity.getVtvLevels().stream().map(VtvLevel.Functions.FROM_VTV_LEVEL_ENTITY).collect(Collectors.toList());
                    group.setVtvLevel(vtvLevelList);
                }
                group.setActive(groupEntity.getActive());
                return group;
            }
        };

        public static Function<Group, GroupEntity> TO_GROUP_ENTITY = new Function<Group, GroupEntity>() {
            @Override
            public GroupEntity apply(Group group) {
                GroupEntity groupEntity = new GroupEntity();
                groupEntity.setId(group.getId());
                groupEntity.setName(group.getName());
                if (!CollectionUtils.isEmpty(group.getVtvLevels())) {
                    List<VtvLevelEntity> vtvLevelEntityList = group.getVtvLevels().stream().map(VtvLevel.Functions.TO_VTV_LEVEL_ENTITY).collect(Collectors.toList());
                    groupEntity.setVtvLevels(new HashSet<>(vtvLevelEntityList));
                }
                groupEntity.setActive(group.getActive());
                return groupEntity;
            }
        };

    }


}
