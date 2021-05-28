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

    updateGroup(group: Group): Observable<Group> {

        return this.http.put<Group>(this.restGroupUrl, group);
    }

    addGroup(group: Group): Observable<Group> {

        return this.http.post<Group>(this.restGroupUrl, group);
    }

    removeGroup(group: Group): Observable<Group> {

        let httpParams = new HttpParams().set('groupId', '' + group.id);

        let options = { params: httpParams };

        return this.http.delete(this.restGroupUrl,options);

    }







}
