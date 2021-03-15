import { createAction, props } from '@ngrx/store';
import {Member} from "@common/models";

export const LoadMembers = createAction(
    'Retrieve all members',
);

export const UpdateMember = createAction(
    'Update member',
    props<{ member: Member }>()
);

export const AddMember = createAction(
    'Add member',
    props<{ member: Member }>()
);


export const LoadMembersSuccess = createAction(
    'Retrieve all members success',
    props<{ members:Member[] }>()
);
