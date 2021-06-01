import {Injectable} from "@angular/core";
import {PlanningRequest, ReservationRequest, WeekPlanning} from "@common/models";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";

@Injectable()
export class PlanningService {

    base_url: string = environment.url + "/rest/planning/";
    week_endpoint = "week";
    generateAndValidate_endpoint = "generateAndValidate";


    constructor(private http: HttpClient) {
    }

    getWeekReservations$(): Observable<WeekPlanning[]> {
        return this.http
            .get<WeekPlanning[]>(this.base_url + this.week_endpoint);
    }

    generateAndValidatePlanning(reservationRequest: ReservationRequest): Observable<WeekPlanning[]> {
        return this.http.post<WeekPlanning[]>(this.base_url + this.generateAndValidate_endpoint, reservationRequest);
    }


}
