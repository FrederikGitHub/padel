package padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION_MEMBER", schema = "padel")
public class ReservationMemberEntity {

    @Id
    @Column(name = "RESERVATION_MEMBER_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Basic
    @JoinColumn(name = "RESERVATION_MEMBER_RESERVATION_ID")
    private ReservationEntity reservation;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_MEMBER_MEMBER_ID")
    private MemberEntity member;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ReservationEntity getReservation() {
        return reservation;
    }

    public void setReservation(ReservationEntity reservation) {
        this.reservation = reservation;
    }

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
    }
}
