import {Action, createReducer, on} from '@ngrx/store';
import {Group, Member} from "@common/models";
import {GroupActions} from "@modules/admin/actions";
import {memberReducer} from "@modules/admin/reducers/member.reducer";


export const initialState: ReadonlyArray<Group> = [];

export const _groupReducer = createReducer(
    initialState,
    on(GroupActions.LoadGroupsSuccess, (state, { groups }) => [...groups])
);

export function groupReducer(state:ReadonlyArray<Group> | undefined, action: Action) {
    return _groupReducer(state, action);
}


