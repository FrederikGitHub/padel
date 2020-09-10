/* tslint:disable: ordered-imports*/
import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {SBRouteData} from '@modules/navigation/models';
import {DashBoardContainerComponent} from "@modules/dashboard/container/dashboard-container.component";
import {DashboardModule} from "@modules/dashboard/dashboard.module";
import {StatsContainerComponent} from "@modules/stats/container/stats-container.component";
import {StatsModule} from "@modules/stats/stats.module";


export const ROUTES: Routes = [

    {
        path: '',
        data: {
            title: 'stats',
            breadcrumbs: [
                {
                    text: 'stats',
                }
            ],
        } as SBRouteData,
        canActivate: [],
        component: StatsContainerComponent,
    },

];


@NgModule({
    imports: [StatsModule, RouterModule.forChild(ROUTES)],
    exports: [RouterModule],
})
export class StatsRoutingModule {
}

