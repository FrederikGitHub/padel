import {Member} from "@common/models";
import {MemberActions} from "@modules/admin/actions";


export interface MemberState {
    members: Member[] | null;
}

export const initialState: MemberState = {
    members: null,
};

export function reducer(
    state = initialState,
    action: MemberActions.MemberActionsUnion
): MemberState {
    switch (action.type) {


        case MemberActions.MemberActionTypes.LOAD_MEMBERS_SUCCESS: {
            return {
                ...state,
                members: action.payload,
            };
        }

        default: {
            return state;
        }
    }
}

export const MEMBERS = (state: MemberState) => state.members;
