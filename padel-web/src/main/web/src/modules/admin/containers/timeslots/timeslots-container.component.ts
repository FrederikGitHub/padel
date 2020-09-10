import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-timeslots-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './timeslots-container.component.html',
})
export class TimeslotsContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
