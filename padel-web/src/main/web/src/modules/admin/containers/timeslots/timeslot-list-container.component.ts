import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {select, Store} from "@ngrx/store";
import {selectTimeSlotState} from "@modules/admin/reducers";
import {TimeSlot} from "@common/models";

@Component({
    selector: 'padel-timeslots-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './timeslot-list-container.component.html',
})
export class TimeslotListContainerComponent implements OnInit {


    timeslots$ = this.store.pipe(select(selectTimeSlotState));


    constructor(private store: Store<{ timeslots: TimeSlot[] }>) {

    }

    ngOnInit() {
        this.store.dispatch({type: 'Retrieve all timeslots'});
    }
}
