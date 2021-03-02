import {Injectable} from "@angular/core";
import {Observable,} from "rxjs";
import {environment} from "../../../environments/environment";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Court, Member, MemberFilterForm} from "@common/models";


@Injectable()
export class CourtService {

    restUrl: string = environment.url + '/rest';
    restCourtUrl: string = this.restUrl + '/court';


    constructor(private http: HttpClient) {

    }

    getCourts():Observable<Array<Court>> {
        let courts$: Observable<Court[]> = this.http.get<Court[]>(this.restCourtUrl);
        return courts$;
    }

    updateCourt(court: Court): Observable<Court> {

        return this.http.put<Court>(this.restCourtUrl, court);
    }

    addGroup(court: Court): Observable<Court> {
        return this.http.post<Court>(this.restCourtUrl, court);
    }



}
