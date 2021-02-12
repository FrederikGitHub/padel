import {Group} from "@common/models";
import {Action} from "@ngrx/store";


export enum GroupActionTypes {
    LOAD_ALL_GROUPS = 'LOAD_ALL_GROUPS',
    ADD_GROUP = 'ADD_GROUP',
    UPDATE_GROUP = 'UPDATE_GROUP',

}


export class LoadGroupsAction implements Action {
    readonly type = GroupActionTypes.LOAD_ALL_GROUPS;

    constructor() {

    }
}

export class UpdateGroupAction implements Action {
    readonly type = GroupActionTypes.UPDATE_GROUP;

    constructor(public payload: Group) {

    }
}

export class AddGroupAction implements Action {
    readonly type = GroupActionTypes.ADD_GROUP;

    constructor(public payload: Group) {

    }
}


export type GroupActionsUnion =
    LoadGroupsAction
    | UpdateGroupAction
    | AddGroupAction;
