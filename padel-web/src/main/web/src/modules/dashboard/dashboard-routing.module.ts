/* tslint:disable: ordered-imports*/
import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {SBRouteData} from '@modules/navigation/models';
import {DashBoardContainerComponent} from "@modules/dashboard/container/dashboard-container.component";
import {DashboardModule} from "@modules/dashboard/dashboard.module";

export const ROUTES: Routes = [

    {
        path: '',
        data: {
            title: 'Dashboard',
            breadcrumbs: [
                {
                    text: 'Dashboard',
                }
            ],
        } as SBRouteData,
        canActivate: [],
        component: DashBoardContainerComponent,
    },

];


@NgModule({
    imports: [DashboardModule, RouterModule.forChild(ROUTES)],
    exports: [RouterModule],
})
export class DashboardRoutingModule {
}
