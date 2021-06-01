import {Injectable} from "@angular/core";
import {Resolve} from "@angular/router";
import {Observable, zip} from "rxjs";
import {Store} from "@ngrx/store";
import {Court, Group, Reservation, ReservationRequest, TimeSlot} from "@common/models";
import {map} from "rxjs/operators";
import {ReservationService} from "@modules/reservations/services/reservation.service";
import {TimeSlotService} from "@common/services/timeslot.service";
import {CourtService} from "@common/services/court.service";


@Injectable({
    providedIn: 'root'
})
export class CourtReservationDataResolverService implements Resolve<any> {

    constructor(private timeSlotService: TimeSlotService, private reservationService: ReservationService, private courtService: CourtService, private store: Store<{ groups: Group[] }>) {
    }

    resolve(): Observable<any> {

        this.initDayReservationData();

        return this.waitForDayReservationDataToLoad();
    }

    waitForDayReservationDataToLoad(): Observable<any> {
        let courts$: Observable<Array<Court>> = this.courtService.getCourts();

        let reservationRequest: ReservationRequest = {};
        reservationRequest.day = new Date().toISOString().split('T')[0];

        let timeSlots$: Observable<Array<TimeSlot>> = this.timeSlotService.getDayTimeSlots(new Date().getDay());

        let dayReservations$: Observable<Array<Reservation>> = this.reservationService.getDayReservations(reservationRequest);


        return zip(courts$, timeSlots$, dayReservations$).pipe(
            map(([courts, timeSlots, dayReservations]) => ({courts, timeSlots, dayReservations})),
        );

    }


    initDayReservationData(): void {

    }


}



