import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
    {
        path: '',
        pathMatch: 'full',
        redirectTo: '/dashboard',
    },
    {
        path: 'error',
        loadChildren: () =>
            import('modules/error/error-routing.module').then(m => m.ErrorRoutingModule),
    },
    {
        path: 'dashboard',
        loadChildren: () =>
            import('modules/dashboard/dashboard-routing.module').then(m => m.DashboardRoutingModule),
    },
    {
        path: 'stats',
        loadChildren: () =>
            import('modules/stats/stats-routing.module').then(m => m.StatsRoutingModule),
    },
    {
        path: 'admin',
        loadChildren: () =>
            import('modules/admin/admin-routing.module').then(m => m.AdminRoutingModule),
    },
    {
        path: 'reservations',
        loadChildren: () =>
            import('modules/reservations/reservation-routing.module').then(m => m.ReservationRoutingModule),
    },
    {
        path: 'poules',
        loadChildren: () =>
            import('modules/poules/poules-routing.module').then(m => m.PoulesRoutingModule),
    },
    {
        path: '**',
        pathMatch: 'full',
        loadChildren: () =>
            import('modules/error/error-routing.module').then(m => m.ErrorRoutingModule),
    },

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}
