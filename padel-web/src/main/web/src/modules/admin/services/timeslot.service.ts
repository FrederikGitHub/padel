import {Injectable} from "@angular/core";
import {Observable,} from "rxjs";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Court, TimeSlot} from "@common/models";


@Injectable()
export class TimeSlotService {

    restUrl: string = environment.url + '/rest';
    restTimeSlotUrl: string = this.restUrl + '/timeslot';


    constructor(private http: HttpClient) {

    }

    getTimeSlots(): Observable<Array<TimeSlot>> {
        let timeSlots$: Observable<TimeSlot[]> = this.http.get<TimeSlot[]>(this.restTimeSlotUrl);
        return timeSlots$;
    }

    updateTimeSlot(timeSlot: TimeSlot): Observable<TimeSlot> {

        return this.http.put<TimeSlot>(this.restTimeSlotUrl, timeSlot);
    }

    addTimeSlot(timeSlot: TimeSlot): Observable<Court> {
        return this.http.post<Court>(this.restTimeSlotUrl, timeSlot);
    }


}
