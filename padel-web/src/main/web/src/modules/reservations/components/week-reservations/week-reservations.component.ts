import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {WeekPlanning} from "@common/models";
import {FakeReservationService} from "@modules/reservations/services/fake-reservation.service";

@Component({
    selector: 'padel-week-reservations',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './week-reservations.component.html',
    styleUrls: ['week-reservations.component.scss'],
})
export class WeekReservationsComponent implements OnInit {

    weekPlannings:WeekPlanning[]=[];


    constructor(private reservationService: FakeReservationService) {}

    ngOnInit() {
        this.getWeekPlannings();
    }


    getWeekPlannings() {
        this.reservationService.getWeekReservations$().subscribe(data => {
            this.weekPlannings = data;
        });
    }
}
