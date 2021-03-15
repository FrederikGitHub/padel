import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {catchError, map, mergeMap} from "rxjs/operators";
import {EMPTY} from "rxjs";
import {AvailabilityService} from "@modules/admin/services/availability.service";

@Injectable()
export class AvailabilityEffects {


    loadAvailabilities$ = createEffect(() =>
        this.actions$.pipe(
            ofType('Retrieve all availablities'),
            mergeMap(() => this.availabilityService$.getAvailabilities()
                .pipe(
                    map(availabilities => ( {type: 'Retrieve all availabilities success', availabilities: availabilities})),
                    catchError(() => EMPTY))
            )
        )
    );


    constructor(
        private actions$: Actions,
        private availabilityService$: AvailabilityService
    ) {
    }
}
