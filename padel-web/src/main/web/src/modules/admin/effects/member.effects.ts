import {Injectable} from '@angular/core';
import {Actions, Effect, ofType} from "@ngrx/effects";
import {Action} from "@ngrx/store";
import {Observable, of} from "rxjs";
import {MemberActions} from "@modules/admin/actions";
import {catchError, exhaustMap, map} from "rxjs/operators";
import {Member, MemberFilterForm} from "@common/models";
import {MemberService} from "@modules/admin/services/member.service";
import {FailureAction, SuccessAction} from "@common/actions/common.action";


@Injectable()
export class MemberEffects {

    @Effect({dispatch: false})
    update$: Observable<Action> = this.actions$.pipe(
        ofType(MemberActions.MemberActionTypes.UPDATE_MEMBER),
        map((action: MemberActions.UpdateMemberAction) => action.payload),
        exhaustMap((member: Member) =>{

                return this.memberService.updateMember(member)
                    .pipe(
                        map((data) => new SuccessAction("Het opslaan van de lidgegevens is gelukt")),
                        catchError(responseError => of(new FailureAction(responseError.error)))
                    )
            }

        )
    );

    @Effect({dispatch: false})
    add$: Observable<Action> = this.actions$.pipe(
        ofType(MemberActions.MemberActionTypes.ADD_MEMBER),
        map((action: MemberActions.AddMemberAction) => action.payload),
        exhaustMap((member: Member) =>{

                return this.memberService.addMember(member)
                    .pipe(
                        map((data) => new SuccessAction("Het opslaan van de lidgegevens is gelukt")),
                        catchError(responseError => of(new FailureAction(responseError.error)))
                    )
            }

        )
    );

    @Effect()
    loadAllMembers$ = this.actions$.pipe(
        ofType(MemberActions.MemberActionTypes.LOAD_MEMBERS),
        exhaustMap(() =>
            this.memberService.getAllMembers()
                .pipe(
                    map((data) => new SuccessAction("Het opslaan van de lidgegevens is gelukt")),
                    catchError(responseError => of(new FailureAction(responseError.error)))
                )
        )
    );

    /*@Effect()
    load$: Observable<Action> = this.actions$.pipe(
        ofType(MemberActions.MemberActionTypes.LOAD_MEMBERS),
        map((action: MemberActions.LoadMembersAction) => action.payload),
        exhaustMap((member: MemberFilterForm) =>{
                this.memberService.getAllMembers(member)
                    .pipe(
                        map((data) => new SuccessAction("Het opslaan van de lidgegevens is gelukt")),
                        catchError(responseError => of(new FailureAction(responseError.error)))
                    )
            }

        )
    );*/


    /*@Effect({dispatch: false})
    loginSuccess$ = this.actions$.pipe(
        ofType(AuthActions.AuthActionTypes.LOGIN_SUCCESS),
        map((action: AuthActions.LoginSuccessAction) => {
            localStorage.setItem("X-Access-Token", action.payload.token);
            this.router.navigateByUrl('/expert')
            this.translate.setDefaultLang(action.payload.language.toLowerCase());
            this.translate.use(action.payload.language.toLowerCase());
            this.translate.get('login.success.message').subscribe((res: string) => {
                this.toastrService.success(res, '', {positionClass: 'toast-bottom-full-width'});
            });


        })
    );*/


    /*@Effect({dispatch: false})
    loginFailure$: Observable<any> = this.actions$.pipe(
        ofType(AuthActions.AuthActionTypes.LOGIN_FAILURE),
        map((action: AuthActions.LoginFailureAction) => {

            this.translate.get('login.error.title').subscribe((res: string) => {
                this.toastrService.error(action.payload, res, {positionClass: 'toast-bottom-full-width'});
            });

        })
    );*/

    constructor(private actions$: Actions,
                private memberService: MemberService,
    ) {

    }
}
