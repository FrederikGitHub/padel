import {createReducer, on} from '@ngrx/store';
import {Availability} from "@common/models";
import {AvailablityActions} from "@modules/admin/actions";


export const initialState: ReadonlyArray<Availability> = [];

export const availabilityReducer = createReducer(
    initialState,
    on(AvailablityActions.LoadAvailabilitiesSuccess, (state, { availabilities }) => [...availabilities])
);


