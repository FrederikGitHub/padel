import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {catchError, map, mergeMap} from "rxjs/operators";
import {EMPTY} from "rxjs";
import {GroupService} from "@common/services/group.service";

@Injectable()
export class GroupEffects {


    loadGroups$ = createEffect(() =>
        this.actions$.pipe(
            ofType('Retrieve all groups'),
            mergeMap(() => this.groupService$.getGroups()
                .pipe(
                    map(groups => ({type: 'Retrieve all groups success', groups: groups})),
                    catchError(() => EMPTY))
            )
        )
    );


    constructor(
        private actions$: Actions,
        private groupService$: GroupService
    ) {
    }
}
