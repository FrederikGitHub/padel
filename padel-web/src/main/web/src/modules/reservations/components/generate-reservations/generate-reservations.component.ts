import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-generate-reservations',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './generate-reservations.component.html',
    styleUrls: ['generate-reservations.component.scss'],
})
export class GenerateReservationsComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
