import {createAction, props} from "@ngrx/store";
import {Group} from "@common/models";

export const LoadGroups = createAction(
    'Retrieve all groups',
    //props<{ Member: any }>()
);

export const UpdateGroup = createAction(
    'Update group',
    props<{ group: Group }>()
);

export const AddGroup = createAction(
    'Add group',
    props<{ group: Group }>()
);

export const RemoveGroup = createAction(
    'Remove group',
    props<{ group: Group }>()
);

export const LoadGroupsSuccess = createAction(
    'Retrieve all groups success',
    props<{ groups:any }>()
);
