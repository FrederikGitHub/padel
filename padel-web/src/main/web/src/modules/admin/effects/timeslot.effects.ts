import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {MemberService} from "@modules/admin/services/member.service";
import {catchError, map, mergeMap} from "rxjs/operators";
import {EMPTY} from "rxjs";
import {CourtService} from "@modules/admin/services/court.service";
import {TimeSlotService} from "@modules/admin/services/timeslot.service";

@Injectable()
export class TimeSlotEffects {



    loadTimeSlots$ = createEffect(() =>
        this.actions$.pipe(
            ofType('Retrieve all timeslots'),
            mergeMap(() => this.timeSlotService.getTimeSlots()
                .pipe(
                    map(timeslots => ( {type: 'Retrieve all timeslots success', timeslots: timeslots})),
                    catchError(() => EMPTY))
            )
        )
    );


    constructor(
        private actions$: Actions,
        private timeSlotService: TimeSlotService
    ) {
    }
}
