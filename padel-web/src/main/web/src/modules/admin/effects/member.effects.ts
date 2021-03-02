import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {MemberService} from "@modules/admin/services/member.service";
import {catchError, map, mergeMap} from "rxjs/operators";
import {EMPTY} from "rxjs";

@Injectable()
export class MemberEffects {


    /*loadMembers$ = createEffect(() => this.actions$.pipe(
        ofType('[Member Page] Load Members'),
        mergeMap(() => this.memberService.getAllMembers()
            .pipe(
                map(members => ({ type: '[Member Page] Load Members', payload: members })),
                catchError(() => EMPTY)
            ))
        )
    );*/


    loadMembers$ = createEffect(() =>
        this.actions$.pipe(
            ofType('Retrieve all members'),
            mergeMap(() => this.memberService.getAllMembers()
                .pipe(
                    map(Member => ( {type: 'Retrieve all members success', members: Member})),
                    catchError(() => EMPTY))
            )
        )
    );


    constructor(
        private actions$: Actions,
        private memberService: MemberService
    ) {
    }
}
