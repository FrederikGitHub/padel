import {createAction, props} from "@ngrx/store";

export const LoadAvailabilities = createAction(
    'Retrieve all availabilities',
    //props<{ Member: any }>()
);


export const LoadAvailabilitiesSuccess = createAction(
    'Retrieve all availabilities success',
    props<{ availabilities:any }>()
);
