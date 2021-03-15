import {Injectable} from "@angular/core";
import {Resolve} from "@angular/router";
import {Observable, of, zip} from "rxjs";
import {select, Store} from "@ngrx/store";
import {selectAvailabilityState, selectGroupState} from "@modules/admin/reducers";
import {AvailabilityService} from "@modules/admin/services/availability.service";
import {Availability, Group} from "@common/models";
import {map} from "rxjs/operators";
import {GroupService} from "@common/services/group.service";


@Injectable({
    providedIn: 'root'
})
export class MemberDataResolverService implements Resolve<any> {

    constructor(private availabilityService: AvailabilityService,private groupService: GroupService, private store: Store<{ groups: Group[] }>) { }

    resolve(): Observable<any> {

        this.initMemberData();

        return this.waitForMemberDataToLoad();
    }

    waitForMemberDataToLoad(): Observable<any> {
        //let availabilities$ = this.store.pipe(select(selectAvailabilityState));
        console.log("dd");
        //let groups$:Observable<ReadonlyArray<Group>> = this.store.pipe(select(selectGroupState));
        //let availabilities$:Observable<ReadonlyArray<Availability>> = this.store.pipe(select(selectAvailabilityState));
        let groups$:Observable<Array<Group>> = this.groupService.getGroups();
        let availabilities$:Observable<Array<Group>> = this.availabilityService.getAvailabilities();
        //levels: string[] = ["P50", "P100", "P200", "P300", "P500", "P750", "P1000"];
        let levels$:Observable<Array<String>> = of (["P50", "P100", "P200", "P300", "P500", "P750", "P1000"]);
        let genders$:Observable<Array<String>> = of (["M", "V"]);
        return zip(availabilities$, groups$,levels$,genders$).pipe(
            map(([availabilities, groups,levels,genders]) => ({ availabilities, groups,levels,genders })),
        );
        //console.log("ee");
        /*let groups$:Observable<Group[]> = of([{id:1,name:"P50",active:"Y",vtvLevel:"P200"},{id:2,name:"P100",active:"Y",vtvLevel:"P100"},{id:3,name:"P200",active:"Y",vtvLevel:"P200"},{id:4,name:"P300",active:"Y",vtvLevel:"P300"}]);
        let availabilities$:Observable<Availability[]> = of([{id:1,label:"Week1",weekNumbers:[1]}]);
        return zip(availabilities$, groups$).pipe(
            map(([availabilities, groups]) => ({ availabilities, groups })),
        )*/
        //return groups$;
        //return groups$;
    }






    initMemberData(): void {
        //this.store.dispatch({ type: 'Retrieve all availabilities' });
        //this.store.dispatch({ type: 'Retrieve all groups' });


        /*this.store.take(1).subscribe(store => {
            if (!store.profile.profileData) {
                this.apiService.getProfileData().toPromise().then(data => {
                    this.store.dispatch(new profileActions.UpdateAction(data));
                });
            }
        });*/
    }



}



