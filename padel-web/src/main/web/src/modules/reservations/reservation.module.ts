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




@NgModule({
    imports: [
        CommonModule,
        RouterModule,
        ReactiveFormsModule,
        FormsModule,
        AppCommonModule,
        NavigationModule,

    ],
    providers: [...reservationServices.services],
    declarations: [...reservationContainers.containers,...reservationComponents.components],
    exports: [...reservationContainers.containers,...reservationComponents.components],

})
export class ReservationModule {}

