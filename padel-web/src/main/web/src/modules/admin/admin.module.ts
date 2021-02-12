/* tslint:disable: ordered-imports*/
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

/* Modules */
import {AppCommonModule} from '@common/app-common.module';
import {NavigationModule} from '@modules/navigation/navigation.module';

/* Components */
import * as adminComponents from './components';

/* Containers */
import * as adminContainers from './containers';
import {AgGridModule} from "ag-grid-angular";
import {StoreModule} from "@ngrx/store";
import {EffectsModule} from "@ngrx/effects";
import {MemberEffects} from "@modules/admin/effects/member.effects";



@NgModule({
    imports: [
        CommonModule,
        RouterModule,
        ReactiveFormsModule,
        FormsModule,
        AppCommonModule,
        AgGridModule,
        NavigationModule,
        //StoreModule.forFeature('admin', reducers),
        //EffectsModule.forFeature([MemberEffects]),
    ],

    declarations: [...adminContainers.containers, ...adminComponents.components],
    exports: [...adminContainers.containers, ...adminComponents.components],
})
export class AdminModule {}
