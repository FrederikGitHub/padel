import { createReducer, on, Action } from '@ngrx/store';
import {Member} from "@common/models";
import {MemberActions} from "@modules/admin/actions";



export const initialState: ReadonlyArray<Member> = [];

export const memberReducer = createReducer(
    initialState,
    on(MemberActions.LoadMembersSuccess, (state, { members }) => [...members])
);


