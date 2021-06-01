import {Injectable} from "@angular/core";
import {Observable,} from "rxjs";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Availability} from "@common/models";


@Injectable()
export class AvailabilityService {

    restUrl: string = environment.url + '/rest';
    restAvailabilitiesUrl: string = this.restUrl + '/availabilities';


    constructor(private http: HttpClient) {

    }


    getAvailabilities():Observable<Array<Availability>> {


        let availabilities$: Observable<Availability[]> = this.http.get<Availability[]>(this.restAvailabilitiesUrl);

        return availabilities$;

    }









}
