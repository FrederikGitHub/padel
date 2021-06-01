import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {catchError, exhaustMap, map, mergeMap} from "rxjs/operators";
import {EMPTY} from "rxjs";
import {AvailabilityService} from "@common/services/availability.service";
import {MemberActions} from "@modules/admin/actions";

@Injectable()
export class AvailabilityEffects {


    loadAvailabilities$ = createEffect(() =>
            this.actions$.pipe(
                ofType('Retrieve all availablities'),
                mergeMap(() => this.availabilityService$.getAvailabilities()
                    .pipe(
                        map(availabilities => ({
                            type: 'Retrieve all availabilities success',
                            availabilities: availabilities
                        })),
                        catchError(() => EMPTY))
                )
            )
        , {dispatch: true});


    constructor(
        private actions$: Actions,
        private availabilityService$: AvailabilityService
    ) {
    }
}
