import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {MemberService} from "@common/services/member.service";
import {catchError, exhaustMap, map, mergeMap} from "rxjs/operators";
import {EMPTY} from "rxjs";

import {Router} from "@angular/router";
import {ReservationActions} from "@modules/reservations/actions";
import {PlanningService, ReservationService} from "@modules/reservations/services";

@Injectable()
export class ReservationEffects {




    generatePlanning$ = createEffect(() =>
            this.actions$.pipe(
                ofType(ReservationActions.GeneratePlanning),
                exhaustMap((action) => this.planningService.generateAndValidatePlanning(action.planningRequest)
                    .pipe(
                        map(() => this.router.navigate(['reservations/week'])),
                        catchError(() => EMPTY))
                )
            )
        , {dispatch: false});


    constructor(
        private router: Router,
        private actions$: Actions,
        private planningService: PlanningService
    ) {
    }
}
