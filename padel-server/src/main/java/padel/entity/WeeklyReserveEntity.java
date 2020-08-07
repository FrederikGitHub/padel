package padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "WEEKLY_RESERVE", schema = "padel")
public class WeeklyReserveEntity {

    @Id
    @Column(name = "WEEKLY_RESERVE_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "WEEKLY_RESERVE_WEEK_NR")
    private Integer weekNr;

    @Basic
    @Column(name = "WEEKLY_RESERVE_YEAR")
    private Integer year;

    @Basic
    @Column(name = "WEEKLY_RESERVE_MEMBER_ID")
    private MemberEntity member;


    @Basic
    @Column(name = "WEEKLY_RESERVE_GROUP_ID")
    private GroupEntity group;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getWeekNr() {
        return weekNr;
    }

    public void setWeekNr(Integer weekNr) {
        this.weekNr = weekNr;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }
}
