import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {MemberService} from "@modules/admin/services/member.service";
import {catchError, map, mergeMap} from "rxjs/operators";
import {EMPTY} from "rxjs";
import {GroupService} from "@modules/admin/services/group.service";

@Injectable()
export class GroupEffects {


    /*loadMembers$ = createEffect(() => this.actions$.pipe(
        ofType('[Member Page] Load Members'),
        mergeMap(() => this.memberService.getAllMembers()
            .pipe(
                map(members => ({ type: '[Member Page] Load Members', payload: members })),
                catchError(() => EMPTY)
            ))
        )
    );*/


    loadGroups$ = createEffect(() =>
        this.actions$.pipe(
            ofType('Retrieve all groups'),
            mergeMap(() => this.groupService$.getGroups()
                .pipe(
                    map(groups => ( {type: 'Retrieve all groups success', groups: groups})),
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
