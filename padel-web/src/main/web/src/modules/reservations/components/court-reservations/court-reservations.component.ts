import {ChangeDetectionStrategy, ChangeDetectorRef, Component, Inject, LOCALE_ID, OnInit} from '@angular/core';
import {Court, Member, Reservation, ReservationRequest, TimeSlot} from "@common/models";
import {ToastrService} from "ngx-toastr";
import {RouteData} from "@common/services/route-data.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Observable, of} from "rxjs";
import {map} from "rxjs/operators";
import {ReservationService} from "@modules/reservations/services";
import {TimeSlotService} from "@common/services";

@Component({
    selector: 'padel-court-reservations',
    templateUrl: './court-reservations.component.html',
    styleUrls: ['court-reservations.component.scss'],
})
export class CourtReservationsComponent implements OnInit {
    courts: Court[] = [];
    dayTimeSlots: TimeSlot[] = [];
    //dayReservations: Observable<Array<Reservation>> = of([]);
    dayReservations: Array<Reservation> = [];
    courtReservationForm: FormGroup;


    constructor(
        @Inject(LOCALE_ID) public locale: string, private toastrService: ToastrService, private routeData: RouteData, private cd: ChangeDetectorRef, private route: ActivatedRoute, private router: Router, private fb: FormBuilder,private timeSlotService: TimeSlotService,private reservationService: ReservationService
    ) {

        this.courts = this.route.snapshot.data['courtReservationResolverData']['courts'];
        this.dayTimeSlots = this.route.snapshot.data['courtReservationResolverData']['timeSlots'];
        this.dayReservations = this.route.snapshot.data['courtReservationResolverData']['dayReservations'];
        this.courtReservationForm = this.fb.group({
            'reservationDay': [""],
        });

    }

    courtTimeSlotReservationMember(court: Court, timeslot: TimeSlot, memberIndex: number): string {
        /*let name: Observable<string> = of("");
        let reservation:Observable<Reservation> = this.dayReservations.pipe(map(reservations => reservations.filter(reservation => reservation.courtTimeSlot?.court?.id == court.id && reservation.courtTimeSlot?.timeSlot?.from?.toLowerCase() == timeslot.from?.toLowerCase() && reservation.courtTimeSlot?.timeSlot?.to?.toLowerCase() == timeslot.to?.toLowerCase())[0]));
        if (reservation){
            // @ts-ignore
            let reservationMembers:Observable<Member[]> = reservation.pipe(map(reservation=>reservation && reservation.reservationMembers));
            let member: Observable<Member> = reservationMembers.pipe(map(members=>members && members[memberIndex]));
            // @ts-ignore
            name = member.pipe(map(member=>member && member.firstName));
        }*/



        //this.dayReservations.pipe(filter(reservation => reservation.)

        let member: string = "";

        let courtTimeSlotReservation: Reservation[] = this.dayReservations.filter(reservation => reservation.courtTimeSlot?.court?.id == court.id && reservation.courtTimeSlot?.timeSlot?.from?.toLowerCase() == timeslot.from?.toLowerCase() && reservation.courtTimeSlot?.timeSlot?.to?.toLowerCase() == timeslot.to?.toLowerCase());
        if (courtTimeSlotReservation && courtTimeSlotReservation.length > 0) {
            // @ts-ignore
            member = courtTimeSlotReservation[0].reservationMembers[memberIndex]?.name + " " + courtTimeSlotReservation[0].reservationMembers[memberIndex]?.firstName;
        }

        return member;
    }


    ngOnInit() {
        this.courtReservationForm.controls.reservationDay.setValue(new Date());
    }

    compareFn(c1: any, c2: any): boolean {
        return c1 && c2 ? c1.id === c2.id : c1 === c2;
    }

    previousDayReservations(){
        console.log("previousDayReservations");
        let currentReservationDate:Date = this.courtReservationForm.controls.reservationDay.value;
        let previousReservationDate:Date = new Date(currentReservationDate.getTime() - 86400000);
        this.courtReservationForm.controls.reservationDay.setValue(previousReservationDate);
        let reservationRequest:ReservationRequest = {};
        reservationRequest.day = this.courtReservationForm.controls.reservationDay.value.toISOString().split('T')[0];
        reservationRequest.day = this.courtReservationForm.controls.reservationDay.value.toISOString().split('T')[0];
        this.reservationService.getDayReservations(reservationRequest).subscribe(data => {
            this.dayReservations = data;

        });
        this.timeSlotService.getDayTimeSlots(previousReservationDate.getDay()).subscribe(data => {
            this.dayTimeSlots = data;

        });

    }

    nextDayReservations(){
        console.log("nextDayReservations");
        let currentReservationDate:Date = this.courtReservationForm.controls.reservationDay.value;
        let nextReservationDate:Date = new Date(currentReservationDate.getTime() + 86400000);
        this.courtReservationForm.controls.reservationDay.setValue(nextReservationDate);
        let reservationRequest:ReservationRequest = {};
        reservationRequest.day = this.courtReservationForm.controls.reservationDay.value.toISOString().split('T')[0];

        this.reservationService.getDayReservations(reservationRequest).subscribe(data => {
            this.dayReservations = data;

        });

        this.timeSlotService.getDayTimeSlots(nextReservationDate.getDay()).subscribe(data => {
            this.dayTimeSlots = data;
        });

    }
}
