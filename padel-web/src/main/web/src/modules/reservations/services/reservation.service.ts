import {Injectable} from "@angular/core";
import {Group, WeekPlanning} from "@common/models";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";

@Injectable()
export class ReservationService {

    base_url: string = environment.url + "/rest/reservation/";
    week_endpoint = "week";

    constructor(private http: HttpClient) {}

    getWeekReservations$():Observable<WeekPlanning[]>{
        return this.http
            .get<WeekPlanning[]>(this.base_url + this.week_endpoint);
    }


}
