import {Injectable} from "@angular/core";
import {Resolve} from "@angular/router";
import {Observable, zip} from "rxjs";
import {Group} from "@common/models";
import {GroupService} from "@common/services";
import {map} from "rxjs/operators";


@Injectable({
    providedIn: 'root'
})
export class WeekReservationsDataResolverService implements Resolve<any> {

    constructor(private groupService: GroupService) {
    }

    resolve(): Observable<any> {

        this.initDayReservationData();

        return this.waitForWeekReservationDataToLoad();
    }

    waitForWeekReservationDataToLoad(): Observable<any> {
        let groups$: Observable<Array<Group>> = this.groupService.getGroups();

        return zip(groups$).pipe(
            map(([groups]) => ({ groups})),
        );

        return groups$;
    }


    initDayReservationData(): void {

    }


}



