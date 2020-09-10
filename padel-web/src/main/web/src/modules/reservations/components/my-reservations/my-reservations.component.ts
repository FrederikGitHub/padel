import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-my-reservations',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './my-reservations.component.html',
    styleUrls: ['my-reservations.component.scss'],
})
export class MyReservationsComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
