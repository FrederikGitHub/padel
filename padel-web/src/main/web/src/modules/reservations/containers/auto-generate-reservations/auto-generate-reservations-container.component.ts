import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-auto-generate-reservations-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './auto-generate-reservations-container.component.html',
    styleUrls: ['auto-generate-reservations-container.component.scss'],
})
export class AutoGenerateReservationsContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
