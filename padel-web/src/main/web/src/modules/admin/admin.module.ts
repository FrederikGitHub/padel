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
import {reducers} from "@modules/admin/reducers";
import {EffectsModule} from "@ngrx/effects";
import {MemberEffects} from "@modules/admin/effects/member.effects";
import {MemberService} from "@common/services/member.service";
import {MatDialogModule} from "@angular/material/dialog";
import {MatListModule} from "@angular/material/list";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatCardModule} from "@angular/material/card";
import {MatIconModule} from "@angular/material/icon";
import {MatInputModule} from "@angular/material/input";
import {MatGridListModule} from "@angular/material/grid-list";
import {GroupService} from "@common/services/group.service";
import {GroupEffects} from "@modules/admin/effects/group.effects";
import {CourtService} from "@common/services/court.service";
import {CourtEffects} from "@modules/admin/effects/court.effects";
import {TimeSlotService} from "@common/services/timeslot.service";
import {TimeSlotEffects} from "@modules/admin/effects/timeslot.effects";
import {AvailabilityService} from "@common/services/availability.service";
import {MemberDataResolverService} from "@modules/admin/services/member-data-resolver.service";
import {NgBootstrapFormValidationModule} from "ng-bootstrap-form-validation";
import {MaterialModule} from "@modules/material/material.module";


@NgModule({
    imports: [
        CommonModule,
        RouterModule,
        ReactiveFormsModule,
        FormsModule,
        MatCardModule,
        MatCheckboxModule,
        MatDialogModule,
        MatIconModule,
        MatInputModule,
        MatListModule,
        MatGridListModule,
        AppCommonModule,
        AgGridModule,
        NavigationModule,
        NgBootstrapFormValidationModule,
        MaterialModule,
        StoreModule.forFeature('admin', reducers),
        EffectsModule.forFeature([MemberEffects,GroupEffects,CourtEffects,CourtEffects,TimeSlotEffects]),
    ],
    providers:[CourtService,TimeSlotService,AvailabilityService,MemberDataResolverService],
    declarations: [...adminContainers.containers, ...adminComponents.components],
    exports: [...adminContainers.containers, ...adminComponents.components],
})
export class AdminModule {}
