import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-court-reservations',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './court-reservations.component.html',
    styleUrls: ['court-reservations.component.scss'],
})
export class CourtReservationsComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
