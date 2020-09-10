import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-court-reservations-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './court-reservations-container.component.html',
    styleUrls: ['court-reservations-container.component.scss'],
})
export class CourtReservationsContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
