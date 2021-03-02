import {createReducer, on} from '@ngrx/store';
import {TimeSlot} from "@common/models";
import {TimeslotActions} from "@modules/admin/actions";


export const initialState: ReadonlyArray<TimeSlot> = [];

export const timeSlotReducer = createReducer(
    initialState,
    on(TimeslotActions.LoadTimeSlotsSuccess, (state, { timeslots }) => [...timeslots])
);


