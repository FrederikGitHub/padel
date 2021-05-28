import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {MemberService} from "@common/services/member.service";
import {catchError, exhaustMap, map, mergeMap} from "rxjs/operators";
import {of} from "rxjs";
import {MemberActions} from "@modules/admin/actions";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {FailureAction, SuccessAction} from "@common/actions/common.action";

@Injectable()
export class MemberEffects {

    loadMembers$ = createEffect(() =>
        this.actions$.pipe(
            ofType(MemberActions.LoadMembers),
            mergeMap(() => this.memberService.getAllMembers()
                .pipe(
                    map(members => ({type: 'Retrieve all members success', members: members})),
                    catchError((responseError) => of(new FailureAction(responseError.error))))
            )
        )
        , {dispatch: true});

    updateMembers$ = createEffect(() =>
        this.actions$.pipe(
            ofType(MemberActions.UpdateMember),
            mergeMap((action) => this.memberService.updateMember(action.member)
                .pipe(
                    map((member) => new SuccessAction('Lidgegegevens zijn correct bewaard')),
                    catchError((responseError) => of(new FailureAction(responseError.error))))
            )
        )
        , {dispatch: true});


    addMembers$ = createEffect(() =>
            this.actions$.pipe(
                ofType(MemberActions.AddMember),
                exhaustMap((action) => this.memberService.addMember(action.member)
                    .pipe(
                        map((member) => new SuccessAction('Lid ' + member.firstName + " " + member.name + " is correct toegevoegd")),
                        catchError((responseError) => of(new FailureAction(responseError.error))))
                )
            )
        , {dispatch: true});


    constructor(
        private router: Router,
        private actions$: Actions,
        private toastrService: ToastrService,
        private memberService: MemberService
    ) {
    }
}
