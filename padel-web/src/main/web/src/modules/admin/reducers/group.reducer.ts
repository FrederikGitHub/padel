import {createReducer, on} from '@ngrx/store';
import {Group} from "@common/models";
import {GroupActions} from "@modules/admin/actions";


export const initialState: ReadonlyArray<Group> = [];

export const groupReducer = createReducer(
    initialState,
    on(GroupActions.LoadGroupsSuccess, (state, { groups }) => [...groups])
);


