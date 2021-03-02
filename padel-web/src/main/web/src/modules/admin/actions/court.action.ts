import {createAction, props} from "@ngrx/store";

export const LoadCourts = createAction(
    'Retrieve all courts',
    //props<{ Member: any }>()
);


export const LoadCourtsSuccess = createAction(
    'Retrieve all courts success',
    props<{ courts:any }>()
);
