import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {MemberService} from "@common/services/member.service";
import {catchError, exhaustMap, map, mergeMap} from "rxjs/operators";
import {EMPTY} from "rxjs";
import {MemberActions} from "@modules/admin/actions";
import {Router} from "@angular/router";

@Injectable()
export class MemberEffects {

    loadMembers$ = createEffect(() =>
        this.actions$.pipe(
            ofType(MemberActions.LoadMembers),
            mergeMap(() => this.memberService.getAllMembers()
                .pipe(
                    map(members => ({type: 'Retrieve all members success', members: members})),
                    catchError(() => EMPTY))
            )
        )
    );

    updateMembers$ = createEffect(() =>
            this.actions$.pipe(
                ofType(MemberActions.UpdateMember),
                exhaustMap((action) => this.memberService.updateMember(action.member)
                    .pipe(
                        map(() => this.router.navigate(['admin/members'])),
                        catchError(() => EMPTY))
                )
            )
        , {dispatch: false});


    addMembers$ = createEffect(() =>
            this.actions$.pipe(
                ofType(MemberActions.AddMember),
                exhaustMap((action) => this.memberService.addMember(action.member)
                    .pipe(
                        map(() => this.router.navigate(['admin/members'])),
                        catchError(() => EMPTY))
                )
            )
        , {dispatch: false});


    constructor(
        private router: Router,
        private actions$: Actions,
        private memberService: MemberService
    ) {
    }
}
