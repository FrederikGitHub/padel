/* tslint:disable: ordered-imports*/
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

/* Modules */
import {AppCommonModule} from '@common/app-common.module';
import {NavigationModule} from '@modules/navigation/navigation.module';
/* Containers */
import * as reservationContainers from './containers';

import * as reservationComponents from './components';

import * as reservationServices from './services';
import {MatDialogModule} from "@angular/material/dialog";
import {MatIconModule} from "@angular/material/icon";
import {MatInputModule} from "@angular/material/input";
import {MatListModule} from "@angular/material/list";
import {MatGridListModule} from "@angular/material/grid-list";
import {EffectsModule} from "@ngrx/effects";
import {ReservationEffects} from "@modules/reservations/effects/reservation.effects";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";


@NgModule({
    imports: [
        CommonModule,
        RouterModule,
        ReactiveFormsModule,
        FormsModule,
        AppCommonModule,
        MatDialogModule,
        MatIconModule,
        MatInputModule,
        MatListModule,
        NgbModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatGridListModule,
        NavigationModule,
        EffectsModule.forFeature([ReservationEffects]),

    ],
    providers: [...reservationServices.services],
    declarations: [...reservationContainers.containers,...reservationComponents.components],
    exports: [...reservationContainers.containers,...reservationComponents.components],

})
export class ReservationModule {}

