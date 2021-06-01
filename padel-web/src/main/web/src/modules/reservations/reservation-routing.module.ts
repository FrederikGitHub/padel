/* tslint:disable: ordered-imports*/
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SBRouteData } from '@modules/navigation/models';

/* Module */
import { ReservationModule } from './reservation.module';

/* Containers */
import * as reservationContainers from './containers';
import {MemberDataResolverService} from "@modules/admin/services/member-data-resolver.service";
import {ReservationDataResolverService} from "@modules/reservations/services/reservation-data-resolver";
import {CourtReservationDataResolverService} from "@modules/reservations/services/court-reservation-data-resolver";

export const ROUTES: Routes = [

    {
        path: 'court',
        data: {
            title: 'Terreinreservaties',
            breadcrumbs: [
                {
                    text: 'Reservaties',
                },
                {
                    text: 'Terrein',
                    active: true,
                },
            ],
        } as SBRouteData,
        resolve: {
            courtReservationResolverData: CourtReservationDataResolverService
        },
        canActivate: [],
        component: reservationContainers.CourtReservationsContainerComponent,
    },
    {
        path: 'week',
        data: {
            title: 'Weekreservaties',
            breadcrumbs: [
                {
                    text: 'Reservaties',
                },
                {
                    text: 'Week',
                    active: true,
                },
            ],
        } as SBRouteData,
        canActivate: [],
        component: reservationContainers.WeekReservationsContainerComponent,
    },
    {
        path: 'my',
        data: {
            title: 'Mijn reservaties',
            breadcrumbs: [
                {
                    text: 'Reservaties',
                },
                {
                    text: 'Mijn reservaties',
                    active: true,
                },
            ],
        } as SBRouteData,
        canActivate: [],
        component: reservationContainers.MyReservationsContainerComponent,
    },
    {
        path: 'auto',
        resolve: {
            reservationResolverData: ReservationDataResolverService
        },
        data: {
            title: 'Genereer reservaties',
            breadcrumbs: [
                {
                    text: 'Reservaties',
                },
                {
                    text: 'Genereer reservaties',
                    active: true,
                },
            ],
        } as SBRouteData,
        canActivate: [],
        component: reservationContainers.AutoGenerateReservationsContainerComponent,
    },

];


@NgModule({
    imports: [ReservationModule, RouterModule.forChild(ROUTES)],
    exports: [RouterModule],
})
export class ReservationRoutingModule {}
