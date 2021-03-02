import {createAction, props} from "@ngrx/store";

export const LoadGroups = createAction(
    'Retrieve all groups',
    //props<{ Member: any }>()
);


export const LoadGroupsSuccess = createAction(
    'Retrieve all groups success',
    props<{ groups:any }>()
);
