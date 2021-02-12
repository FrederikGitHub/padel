import {Member, MemberFilterForm} from "@common/models";
import {Action} from "@ngrx/store";


export enum MemberActionTypes {
    LOAD_MEMBERS = 'LOAD_MEMBERS',
    LOAD_MEMBERS_SUCCESS = 'LOAD_MEMBERS_SUCCESS',
    LOAD_MEMBERS_BY_GROUP = 'LOAD_MEMBERS_BY_GROUP',
    LOAD_MEMBERS_BY_LEVEL = 'LOAD_MEMBERS_BY_LEVEL',
    ADD_MEMBER = 'ADD_MEMBER',
    UPDATE_MEMBER = 'UPDATE_MEMBER',
    REMOVE_MEMBER = 'REMOVE_MEMBER'
}


export class LoadMembersAction implements Action {
    readonly type = MemberActionTypes.LOAD_MEMBERS;

    constructor(public payload: MemberFilterForm[]) {

    }
}

export class LoadMembersSuccessAction implements Action {
    readonly type = MemberActionTypes.LOAD_MEMBERS_SUCCESS;

    constructor(public payload: Member[]) {

    }
}

export class UpdateMemberAction implements Action {
    readonly type = MemberActionTypes.UPDATE_MEMBER;

    constructor(public payload: Member) {

    }
}

export class AddMemberAction implements Action {
    readonly type = MemberActionTypes.ADD_MEMBER;

    constructor(public payload: Member) {

    }
}


export type MemberActionsUnion =
    LoadMembersAction
    | LoadMembersSuccessAction
    | UpdateMemberAction;
