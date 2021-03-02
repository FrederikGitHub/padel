import {createReducer, on} from '@ngrx/store';
import {TimeSlot} from "@common/models";
import {CourtActions} from "@modules/admin/actions";


export const initialState: ReadonlyArray<TimeSlot> = [];

export const courtReducer = createReducer(
    initialState,
    on(CourtActions.LoadCourtsSuccess, (state, {courts}) => [...courts])
);


