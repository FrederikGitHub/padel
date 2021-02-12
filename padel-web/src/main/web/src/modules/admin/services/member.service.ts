import {Injectable} from "@angular/core";
import {Observable,} from "rxjs";
import {environment} from "../../../environments/environment";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Member, MemberFilterForm} from "@common/models";


@Injectable()
export class MemberService {

    restUrl: string = environment.url + '/rest';
    restMemberUrl: string = this.restUrl + '/member';


    constructor(private http: HttpClient) {

    }

    getMembers(memberFilterForm:MemberFilterForm): Observable<Member[]> {


        let members$: Observable<Member[]> = this.http.post<Member[]>(this.restMemberUrl,memberFilterForm);

        return members$;

    }

    getAllMembers(): Observable<Member[]> {


        let members$: Observable<Member[]> = this.http.get<Member[]>(this.restMemberUrl);

        return members$;

    }

    getMembersForLevel(level: string): Observable<Member[]> {

        const opts = { params: new HttpParams().set('level', level) };

        let members$: Observable<Member[]> = this.http.get<Member[]>(this.restMemberUrl,opts);

        return members$;

    }

    getMembersForGroup(group: string): Observable<Member[]> {

        const opts = { params: new HttpParams().set('groupAvailability', group) };

        let members$: Observable<Member[]> = this.http.get<Member[]>(this.restMemberUrl,opts);

        return members$;

    }


    updateMember(member: Member): Observable<Member> {

        return this.http.put<Member>(this.restMemberUrl, member);
    }

    addMember(member: Member): Observable<Member> {

        return this.http.post<Member>(this.restMemberUrl, member);
    }







}
