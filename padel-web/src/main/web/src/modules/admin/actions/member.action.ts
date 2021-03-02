import { createAction, props } from '@ngrx/store';

export const LoadMembers = createAction(
    'Retrieve all members',
    props<{ Member: any }>()
);


export const LoadMembersSuccess = createAction(
    'Retrieve all members success',
    props<{ members:any }>()
);
