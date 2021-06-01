import {Injectable} from "@angular/core";
import {Reservation, ReservationRequest, WeekPlanning} from "@common/models";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";

@Injectable()
export class ReservationService {

    base_url: string = environment.url + "/rest/reservation/";
    week_endpoint = "week";
    generateAndValidate_endpoint = "generateAndValidate";
    dayReservation_endpoint = "day";


    constructor(private http: HttpClient) {
    }

    getWeekReservations(): Observable<WeekPlanning[]> {
        return this.http
            .get<WeekPlanning[]>(this.base_url + this.week_endpoint);
    }

    getDayReservations(reservationRequest: ReservationRequest): Observable<Reservation[]> {
        console.log("ReservationService getDayReservations");
        return this.http.post<Reservation[]>(this.base_url + this.dayReservation_endpoint, reservationRequest);
    }



    generateAndValidatePlanning(reservationRequest: ReservationRequest): Observable<WeekPlanning[]> {
        return this.http.post<WeekPlanning[]>(this.base_url + this.generateAndValidate_endpoint, reservationRequest);
    }


}
