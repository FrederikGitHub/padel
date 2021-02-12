import {Action} from "@ngrx/store";


export enum CommonActionTypes {
    SUCCESS_ACTION = 'SUCCESS_ACTION',
    FAILURE_ACTION = 'FAILURE_ACTION',
}


export class SuccessAction implements Action {
    readonly type = CommonActionTypes.SUCCESS_ACTION;

    constructor(public payload: string) {

    }
}

export class FailureAction implements Action {
    readonly type = CommonActionTypes.FAILURE_ACTION;

    constructor(public payload: string) {

    }
}


export type CommonActionsUnion =
    SuccessAction
    | FailureAction;
