/* tslint:disable: ordered-imports*/
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

/* Modules */
import {AppCommonModule} from '@common/app-common.module';
import {NavigationModule} from '@modules/navigation/navigation.module';
import {DashBoardComponent} from "@modules/dashboard/components/dashboard.component";
import {DashBoardContainerComponent} from "@modules/dashboard/container/dashboard-container.component";
import {StatsComponent} from "@modules/stats/components/stats.component";
import {StatsContainerComponent} from "@modules/stats/container/stats-container.component";
/* Containers */





@NgModule({
    imports: [
        CommonModule,
        RouterModule,
        ReactiveFormsModule,
        FormsModule,
        AppCommonModule,
        NavigationModule,

    ],

    declarations: [StatsComponent,StatsContainerComponent],
    exports: [StatsComponent,StatsContainerComponent],

})
export class StatsModule {}

