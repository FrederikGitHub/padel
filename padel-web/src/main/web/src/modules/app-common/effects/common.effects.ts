import {Injectable} from '@angular/core';
import {Actions, Effect, ofType} from "@ngrx/effects";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {ToastrService} from "ngx-toastr";
import {CommonActions} from "@common/actions";


@Injectable()
export class CommonEffects {


    @Effect({dispatch: false})
    success$: Observable<any> = this.actions$.pipe(
        ofType(CommonActions.CommonActionTypes.SUCCESS_ACTION),
        map((action: CommonActions.SuccessAction) => {
            this.toastrService.success(action.payload, '', {positionClass: 'toast-bottom-full-width'});
        })
    );

    @Effect({dispatch: false})
    failure$: Observable<any> = this.actions$.pipe(
        ofType(CommonActions.CommonActionTypes.FAILURE_ACTION),
        map((action: CommonActions.SuccessAction) => {
            this.toastrService.error(action.payload, '', {positionClass: 'toast-bottom-full-width'});
        })
    );

    constructor(private actions$: Actions,
                private toastrService: ToastrService) {

    }


}
