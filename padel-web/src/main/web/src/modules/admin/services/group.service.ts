import {Injectable} from "@angular/core";
import {Observable,} from "rxjs";
import {environment} from "../../../environments/environment";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Group, Member, MemberFilterForm} from "@common/models";


@Injectable()
export class GroupService {

    restUrl: string = environment.url + '/rest';
    restGroupUrl: string = this.restUrl + '/group';


    constructor(private http: HttpClient) {

    }


    getGroups():Observable<Array<Group>> {


        let groups$: Observable<Group[]> = this.http.get<Group[]>(this.restGroupUrl);

        return groups$;

    }

    updateGroup(member: Member): Observable<Member> {

        return this.http.put<Member>(this.restGroupUrl, member);
    }

    addGroup(member: Member): Observable<Member> {

        return this.http.post<Member>(this.restGroupUrl, member);
    }







}
