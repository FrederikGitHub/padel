import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-week-reservations-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './week-reservations-container.component.html',
    styleUrls: ['week-reservations-container.component.scss'],
})
export class WeekReservationsContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
