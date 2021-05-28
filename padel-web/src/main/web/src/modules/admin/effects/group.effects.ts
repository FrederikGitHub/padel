import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {catchError, exhaustMap, map, mergeMap} from "rxjs/operators";
import {EMPTY, of} from "rxjs";
import {GroupService} from "@common/services/group.service";
import {GroupActions, MemberActions} from "@modules/admin/actions";
import {FailureAction, SuccessAction} from "@common/actions/common.action";

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
        , {dispatch: true});

    updateGroup$ = createEffect(() =>
        this.actions$.pipe(
            ofType(GroupActions.UpdateGroup),
            mergeMap((action) => this.groupService$.updateGroup(action.group)
                .pipe(
                    map((group) => new SuccessAction('Groep gegevens zijn correct bewaard')),
                    catchError((responseError) => of(new FailureAction(responseError.error))))
            )
        )
    );


    addGroup$ = createEffect(() =>
            this.actions$.pipe(
                ofType(GroupActions.AddGroup),
                exhaustMap((action) => this.groupService$.addGroup(action.group)
                    .pipe(
                        map((group) => new SuccessAction('Groep ' + group.name + " is correct toegevoegd")),
                        catchError((responseError) => of(new FailureAction(responseError.error))))
                )
            )
        , {dispatch: true});

    removeGroup$ = createEffect(() =>
            this.actions$.pipe(
                ofType(GroupActions.RemoveGroup),
                exhaustMap((action) => this.groupService$.removeGroup(action.group)
                    .pipe(
                        map((group) => new SuccessAction('Groep ' + group.name + " is correct verwijderd")),
                        catchError((responseError) => of(new FailureAction(responseError.error))))
                )
            )
        , {dispatch: true});


    constructor(
        private actions$: Actions,
        private groupService$: GroupService
    ) {
    }
}
