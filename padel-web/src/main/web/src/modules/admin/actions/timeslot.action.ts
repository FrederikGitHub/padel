import {createAction, props} from "@ngrx/store";

export const LoadTimeSlots = createAction(
    'Retrieve all timeslots',
);


export const LoadTimeSlotsSuccess = createAction(
    'Retrieve all timeslots success',
    props<{ timeslots:any }>()
);
