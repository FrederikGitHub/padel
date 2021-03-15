import {Action, createReducer, on, State} from '@ngrx/store';
import {Member} from "@common/models";
import {MemberActions} from "@modules/admin/actions";


export const initialState: ReadonlyArray<Member> = [];

export const _memberReducer = createReducer(
    initialState,
    on(MemberActions.LoadMembersSuccess, (state, { members }) => [...members])
);


export function memberReducer(state:ReadonlyArray<Member> | undefined, action: Action) {
    return _memberReducer(state, action);
}


