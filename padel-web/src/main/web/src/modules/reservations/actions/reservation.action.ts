import {createAction, props} from '@ngrx/store';
import {ReservationRequest} from "@common/models";


export const GeneratePlanning = createAction(
    'Generate planning',
    props<{ reservationRequest: ReservationRequest }>()
);

