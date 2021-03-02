import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-timeslot-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './timeslot-container.component.html',
})
export class TimeSlotContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
