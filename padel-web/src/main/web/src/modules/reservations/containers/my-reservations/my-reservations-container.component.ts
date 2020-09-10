import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-my-reservations-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './my-reservations-container.component.html',
    styleUrls: ['my-reservations-container.component.scss'],
})
export class MyReservationsContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
