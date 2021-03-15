import {Injectable} from "@angular/core";
import {Resolve} from "@angular/router";
import {Observable, zip} from "rxjs";
import {Store} from "@ngrx/store";
import {CourtTimeSlot, Group, Member} from "@common/models";
import {map} from "rxjs/operators";
import {GroupService} from "@common/services/group.service";
import {MemberService} from "@common/services/member.service";
import {CourtTimeSlotService} from "@common/services";


@Injectable({
    providedIn: 'root'
})
export class ReservationDataResolverService implements Resolve<any> {

    constructor(private courtTimeSlotService:CourtTimeSlotService, private memberService: MemberService,private groupService: GroupService, private store: Store<{ groups: Group[] }>) { }

    resolve(): Observable<any> {

        this.initReservationData();

        return this.waitForReservationDataToLoad();
    }

    waitForReservationDataToLoad(): Observable<any> {
        //let availabilities$ = this.store.pipe(select(selectAvailabilityState));

        //let groups$:Observable<ReadonlyArray<Group>> = this.store.pipe(select(selectGroupState));
        //let availabilities$:Observable<ReadonlyArray<Availability>> = this.store.pipe(select(selectAvailabilityState));
        let groups$:Observable<Array<Group>> = this.groupService.getGroups();
        let members$:Observable<Array<Member>> = this.memberService.getAllMembers();
        let courtTimeSlots$:Observable<Array<CourtTimeSlot>> = this.courtTimeSlotService.getCourtTimeSlots();


        return zip(groups$, members$,courtTimeSlots$).pipe(
            map(([groups, members,courtTimeSlots]) => ({ groups, members,courtTimeSlots})),
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






    initReservationData(): void {
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



