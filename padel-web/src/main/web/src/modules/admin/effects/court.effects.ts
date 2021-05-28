import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {catchError, exhaustMap, map, mergeMap} from "rxjs/operators";
import {EMPTY, of} from "rxjs";
import {CourtService} from "@modules/admin/services/court.service";
import {CourtActions, GroupActions} from "@modules/admin/actions";
import {FailureAction, SuccessAction} from "@common/actions/common.action";

@Injectable()
export class CourtEffects {


    loadCourts$ = createEffect(() =>
        this.actions$.pipe(
            ofType('Retrieve all courts'),
            mergeMap(() => this.courtService.getCourts()
                .pipe(
                    map(courts => ({type: 'Retrieve all courts success', courts: courts})),
                    catchError(() => EMPTY))
            )
        )
        , {dispatch: true});


    updateCourt$ = createEffect(() =>
        this.actions$.pipe(
            ofType(CourtActions.UpdateCourt),
            mergeMap((action) => this.courtService.updateCourt(action.court)
                .pipe(
                    map((court) => new SuccessAction('Terrein gegevens zijn correct bewaard')),
                    catchError((responseError) => of(new FailureAction(responseError.error))))
            )
        )
        , {dispatch: true});


    addCourt$ = createEffect(() =>
            this.actions$.pipe(
                ofType(CourtActions.AddCourt),
                exhaustMap((action) => this.courtService.addCourt(action.court)
                    .pipe(
                        map((court) => new SuccessAction('Terrein ' + court.name + " is correct toegevoegd")),
                        catchError((responseError) => of(new FailureAction(responseError.error))))
                )
            )
        , {dispatch: true});


    constructor(
        private actions$: Actions,
        private courtService: CourtService
    ) {
    }
}
