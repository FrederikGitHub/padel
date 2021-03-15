import {Action, createReducer, on} from '@ngrx/store';
import {Availability} from "@common/models";
import {AvailablityActions} from "@modules/admin/actions";


export const initialState: ReadonlyArray<Availability> = [];

export const _availabilityReducer = createReducer(
    initialState,
    on(AvailablityActions.LoadAvailabilitiesSuccess, (state, { availabilities }) => [...availabilities])
);

export function availabilityReducer(state:ReadonlyArray<Availability> | undefined, action: Action) {
    return _availabilityReducer(state, action);
}


