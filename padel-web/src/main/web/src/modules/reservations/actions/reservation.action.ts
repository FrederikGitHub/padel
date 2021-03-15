import {createAction, props} from '@ngrx/store';
import {PlanningRequest} from "@common/models";


export const GeneratePlanning = createAction(
    'Generate planning',
    props<{ planningRequest: PlanningRequest }>()
);

