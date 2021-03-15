import {Action, createReducer, on} from '@ngrx/store';
import {TimeSlot} from "@common/models";
import {TimeslotActions} from "@modules/admin/actions";


export const initialState: ReadonlyArray<TimeSlot> = [];

export const _timeSlotReducer = createReducer(
    initialState,
    on(TimeslotActions.LoadTimeSlotsSuccess, (state, { timeslots }) => [...timeslots])
);

export function timeSlotReducer(state:ReadonlyArray<TimeSlot> | undefined, action: Action) {
    return _timeSlotReducer(state, action);
}


