import {Action, createReducer, on} from '@ngrx/store';
import {TimeSlot} from "@common/models";
import {CourtActions} from "@modules/admin/actions";


export const initialState: ReadonlyArray<TimeSlot> = [];

export const _courtReducer = createReducer(
    initialState,
    on(CourtActions.LoadCourtsSuccess, (state, {courts}) => [...courts])
);


export function courtReducer(state:ReadonlyArray<TimeSlot> | undefined, action: Action) {
    return _courtReducer(state, action);
}


