/* tslint:disable: ordered-imports*/
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SBRouteData} from '@modules/navigation/models';

/* Components */
/* Containers */
import * as adminContainers from './containers';
import {AdminModule} from "@modules/admin/admin.module";
import {MemberDataResolverService} from "@modules/admin/services/member-data-resolver.service";


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
        component: adminContainers.CourtListContainerComponent,
    },
    {
        path: 'court/edit/:courtId',
        data: {
            title: 'Terrein',
            breadcrumbs: [
                {
                    text: 'Admin',
                    active: true,
                },
                {
                    text: 'Terrein',
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
        component: adminContainers.GroupListContainerComponent,
    },
    {
        path: 'members/edit/:memberId',
        resolve: {
            memberResolverData: MemberDataResolverService
        },
        data: {
            title: 'ddd',
            breadcrumbs: [
                {
                    text: 'Admin',
                    active: true,
                },
                {
                    text: 'Lid',
                    active: true,
                },
            ],
        } as SBRouteData,
        canActivate: [],
        component: adminContainers.MemberContainerComponent,
    },
    {
        path: 'group/edit/:groupId',
        data: {
            title: 'ddd',
            breadcrumbs: [
                {
                    text: 'Admin',
                    active: true,
                },
                {
                    text: 'groep',
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
        children: [
            {
                path: 'edit/:memberId', component: adminContainers.MemberContainerComponent,
            },
        ],
        component: adminContainers.MemberListContainerComponent,
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
        component: adminContainers.TimeslotListContainerComponent,
    },
    {
        path: 'timeslots/edit/:timeslotId',
        data: {
            title: 'Timeslot',
            breadcrumbs: [
                {
                    text: 'Admin',
                    active: true,
                },
                {
                    text: 'Timeslot',
                    active: true,
                },
            ],
        } as SBRouteData,
        canActivate: [],
        component: adminContainers.TimeSlotContainerComponent,
    },


];

@NgModule({
    imports: [AdminModule, RouterModule.forChild(ROUTES)],
    exports: [RouterModule],
})
export class AdminRoutingModule {
}
