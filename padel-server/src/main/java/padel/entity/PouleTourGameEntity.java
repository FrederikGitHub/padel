package padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "POULE_TOUR_GAME", schema = "padel")
public class PouleTourGameEntity {
    @Id
    @Column(name = "POULE_TOUR_GAME_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "POULE_TOUR_GAME_POULE_ID")
    private PouleEntity poule;

    @ManyToOne
    @JoinColumn(name = "POULE_TOUR_GAME_POULE_TOUR_ID")
    private PouleTourEntity pouleTour;

    @Basic
    @Column(name = "POULE_TOUR_GAME_POULE_TOUR_ID_PLAY_STATE_ID")
    private PlayStateEntity state;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PouleTourEntity getPouleTour() {
        return pouleTour;
    }

    public void setPouleTour(PouleTourEntity pouleTour) {
        this.pouleTour = pouleTour;
    }

    public PlayStateEntity getState() {
        return state;
    }

    public void setState(PlayStateEntity state) {
        this.state = state;
    }

    public PouleEntity getPoule() {
        return poule;
    }

    public void setPoule(PouleEntity poule) {
        this.poule = poule;
    }
}
