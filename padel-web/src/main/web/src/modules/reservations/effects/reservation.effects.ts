import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {catchError, exhaustMap, map} from "rxjs/operators";
import {EMPTY} from "rxjs";

import {Router} from "@angular/router";
import {ReservationActions} from "@modules/reservations/actions";
import {ReservationService} from "@modules/reservations/services";

@Injectable()
export class ReservationEffects {




    generatePlanning$ = createEffect(() =>
            this.actions$.pipe(
                ofType(ReservationActions.GeneratePlanning),
                exhaustMap((action) => this.reservationService.getWeekReservations(action.reservationRequest)
                    .pipe(
                        map(() => this.router.navigate(['reservations/week'])),
                        catchError(() => EMPTY))
                )
            )
        , {dispatch: false});


    constructor(
        private router: Router,
        private actions$: Actions,
        private reservationService: ReservationService
    ) {
    }
}
