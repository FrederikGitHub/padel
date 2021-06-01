import {Injectable} from "@angular/core";
import {Observable,} from "rxjs";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {CourtTimeSlot} from "@common/models";


@Injectable()
export class CourtTimeSlotService {

    restUrl: string = environment.url + '/rest';
    restCourtTimeSlotUrl: string = this.restUrl + '/courtTimeSlot';


    constructor(private http: HttpClient) {

    }

    getCourtTimeSlots(): Observable<CourtTimeSlot[]> {


        let courtTimeSlots$: Observable<CourtTimeSlot[]> = this.http.get<CourtTimeSlot[]>(this.restCourtTimeSlotUrl);

        return courtTimeSlots$;

    }




}
