package com.realdolmen.padel.model;

import java.util.Objects;
import java.util.UUID;

public class TimeSlotGroupMembers {
    private String uuid;
    private Group group;
    private Integer totalMembers;

    public TimeSlotGroupMembers(Group group, Integer totalMembers) {
        this.uuid = UUID.randomUUID().toString();
        this.group = group;
        this.totalMembers = totalMembers;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(Integer totalMembers) {
        this.totalMembers = totalMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlotGroupMembers that = (TimeSlotGroupMembers) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
