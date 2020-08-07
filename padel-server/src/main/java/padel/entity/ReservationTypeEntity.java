package padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION_TYPE", schema = "padel")
public class ReservationTypeEntity {
    @Id
    @Column(name = "RESERVATION_TYPE_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "RESERVATION_TYPE_NAME")
    private String name;

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
}
