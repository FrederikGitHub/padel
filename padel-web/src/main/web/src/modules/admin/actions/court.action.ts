import {createAction, props} from "@ngrx/store";
import {Court, Group} from "@common/models";

export const LoadCourts = createAction(
    'Retrieve all courts',
    //props<{ Member: any }>()
);

export const UpdateCourt = createAction(
    'Update court',
    props<{ court: Court }>()
);

export const AddCourt = createAction(
    'Add court',
    props<{ court: Court }>()
);

export const LoadCourtsSuccess = createAction(
    'Retrieve all courts success',
    props<{ courts:any }>()
);
