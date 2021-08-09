import {ChangeDetectionStrategy, ChangeDetectorRef, Component, Inject, LOCALE_ID, OnInit} from '@angular/core';
import {Group, ReservationRequest, WeekPlanning} from "@common/models";
import {FakeReservationService} from "@modules/reservations/services/fake-reservation.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {RouteData} from "@common/services/route-data.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ReservationService} from "@modules/reservations/services";

@Component({
    selector: 'padel-week-reservations',
    templateUrl: './week-reservations.component.html',
    styleUrls: ['week-reservations.component.scss'],
})
export class WeekReservationsComponent implements OnInit {

    weekPlannings:WeekPlanning[] = [];
    weekReservationForm: FormGroup;
    groups: Group[];

    constructor(
        @Inject(LOCALE_ID) public locale: string,private toastrService: ToastrService, private routeData: RouteData, private cd: ChangeDetectorRef, private route: ActivatedRoute, private router: Router, private fb: FormBuilder,private reservationService: ReservationService
    ) {
        this.weekReservationForm = this.fb.group({
            'fromDate': ["", Validators.required],
            'toDate': ["", Validators.required],
            'group': ["", Validators.required],
        });


        this.groups = this.route.snapshot.data['weekReservationsResolverData']['groups'];


    }

    compareFn(c1: any, c2: any): boolean {
        return c1 && c2 ? c1.id === c2.id : c1 === c2;
    }

    showReservations(){
        let reservationRequest:ReservationRequest = {};
        reservationRequest.fromDate = this.weekReservationForm.controls.fromDate.value.toISOString().split('T')[0];
        reservationRequest.toDate = this.weekReservationForm.controls.toDate.value.toISOString().split('T')[0];
        reservationRequest.group = this.weekReservationForm.controls.group.value;

        this.reservationService.getWeekReservations(reservationRequest).subscribe(data => {
            this.weekPlannings = data;
        });
    }

    ngOnInit() {
        //this.getWeekPlannings();
    }


    getWeekPlannings() {
        /*this.reservationService.getWeekReservations$().subscribe(data => {
            this.weekPlannings = data;
        });*/
    }
}
