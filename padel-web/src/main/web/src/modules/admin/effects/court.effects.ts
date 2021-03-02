import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {catchError, map, mergeMap} from "rxjs/operators";
import {EMPTY} from "rxjs";
import {CourtService} from "@modules/admin/services/court.service";

@Injectable()
export class CourtEffects {


    /*loadMembers$ = createEffect(() => this.actions$.pipe(
        ofType('[Member Page] Load Members'),
        mergeMap(() => this.memberService.getAllMembers()
            .pipe(
                map(members => ({ type: '[Member Page] Load Members', payload: members })),
                catchError(() => EMPTY)
            ))
        )
    );*/


    loadCourts$ = createEffect(() =>
        this.actions$.pipe(
            ofType('Retrieve all courts'),
            mergeMap(() => this.courtService.getCourts()
                .pipe(
                    map(courts => ( {type: 'Retrieve all courts success', courts: courts})),
                    catchError(() => EMPTY))
            )
        )
    );


    constructor(
        private actions$: Actions,
        private courtService: CourtService
    ) {
    }
}
