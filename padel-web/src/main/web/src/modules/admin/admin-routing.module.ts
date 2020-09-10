/* tslint:disable: ordered-imports*/
import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {SBRouteData} from '@modules/navigation/models';

/* Components */
import * as adminComponents from './components';

/* Containers */
import * as adminContainers from './containers';
import {AdminModule} from "@modules/admin/admin.module";


/* Routes */
export const ROUTES: Routes = [

    {
        path: 'court',
        data: {
            title: 'Terreinen',
            breadcrumbs: [
                {
                    text: 'Admin',
                    active: true,
                },
                {
                    text: 'Terreinen',
                    active: true,
                },
            ],
        } as SBRouteData,
        canActivate: [],
        component: adminContainers.CourtContainerComponent,
    },
    {
        path: 'group',
        data: {
            title: 'Groepen',
            breadcrumbs: [
                {
                    text: 'Admin',
                    active: true,
                },
                {
                    text: 'Groepen',
                    active: true,
                },
            ],
        } as SBRouteData,
        canActivate: [],
        component: adminContainers.GroupContainerComponent,
    },
    {
        path: 'members',
        data: {
            title: 'Leden',
            breadcrumbs: [
                {
                    text: 'Admin',
                    active: true,
                },
                {
                    text: 'Leden',
                    active: true,
                },
            ],
        } as SBRouteData,
        canActivate: [],
        component: adminContainers.MemberContainerComponent,
    }, {
        path: 'poule',
        data: {
            title: 'Poules',
            breadcrumbs: [
                {
                    text: 'Admin',
                    active: true,
                },
                {
                    text: 'Poules',
                    active: true,
                },
            ],
        } as SBRouteData,
        canActivate: [],
        component: adminContainers.PouleContainerComponent,
    }, {
        path: 'timeslots',
        data: {
            title: 'Timeslots',
            breadcrumbs: [
                {
                    text: 'Admin',
                    active: true,
                },
                {
                    text: 'Timeslots',
                    active: true,
                },
            ],
        } as SBRouteData,
        canActivate: [],
        component: adminContainers.TimeslotsContainerComponent,
    }

];

@NgModule({
    imports: [AdminModule, RouterModule.forChild(ROUTES)],
    exports: [RouterModule],
})
export class AdminRoutingModule {
}
