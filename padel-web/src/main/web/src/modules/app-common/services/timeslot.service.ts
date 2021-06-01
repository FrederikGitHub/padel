import {Injectable} from "@angular/core";
import {Observable,} from "rxjs";
import {environment} from "../../../environments/environment";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Court, TimeSlot} from "@common/models";


@Injectable()
export class TimeSlotService {

    restUrl: string = environment.url + '/rest';
    restTimeSlotUrl: string = this.restUrl + '/timeslot';
    restDayTimeSlotUrl = this.restTimeSlotUrl + "/day"

    constructor(private http: HttpClient) {

    }

    getTimeSlots(): Observable<Array<TimeSlot>> {

        let timeSlots$: Observable<TimeSlot[]> = this.http.get<TimeSlot[]>(this.restTimeSlotUrl);
        return timeSlots$;
    }


    getDayTimeSlots(dayOfWeek:number): Observable<Array<TimeSlot>> {

        const opts = { params: new HttpParams().set('dayOfWeek', ''+dayOfWeek) };

        let timeSlots$: Observable<TimeSlot[]> = this.http.get<TimeSlot[]>(this.restDayTimeSlotUrl,opts);
        return timeSlots$;
    }






    updateTimeSlot(timeSlot: TimeSlot): Observable<TimeSlot> {

        return this.http.put<TimeSlot>(this.restTimeSlotUrl, timeSlot);
    }

    addTimeSlot(timeSlot: TimeSlot): Observable<Court> {
        return this.http.post<Court>(this.restTimeSlotUrl, timeSlot);
    }


}
