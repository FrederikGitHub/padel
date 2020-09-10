/* tslint:disable: ordered-imports*/
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SBRouteData } from '@modules/navigation/models';

/* Containers */
import * as pouleContainers from './containers';
import {PoulesModule} from "@modules/poules/poules.module";



/* Routes */
export const ROUTES: Routes = [

    {
        path: 'admin',
        data: {
            title: 'Beheer',
            breadcrumbs: [
                {
                    text: 'poules',
                    link: '/admins',
                },
                {
                    text: 'admin',
                    active: true,
                },
            ],
        } as SBRouteData,
        canActivate: [],
        component: pouleContainers.PouleAdminContainerComponent,
    },
    {
        path: 'results',
        data: {
            title: 'Resultaten',
            breadcrumbs: [
                {
                    text: 'Poules',
                },
                {
                    text: 'Resultaten',
                    active: true,
                },
            ],
        } as SBRouteData,
        canActivate: [],
        component: pouleContainers.PouleResultsContainerComponent,
    }
];

@NgModule({
    imports: [PoulesModule, RouterModule.forChild(ROUTES)],
    exports: [RouterModule],
})
export class PoulesRoutingModule {}
