package padel.model;

import java.util.List;

public class WeekPlanning {
    public List<Reservation> reservationList;
    public List<Member> reserveList;

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;

    }

    public List<Member> getReserveList() {
        return reserveList;
    }

    public void setReserveList(List<Member> reserveList) {
        this.reserveList = reserveList;

    }

    @Override
    public String toString() {
        return "WeekPlanning{" +
                "reservationList=" + reservationList +
                ", reserveList=" + reserveList +
                '}';
    }
}
