import {CourtReservationsComponent} from "./court-reservations/court-reservations.component";
import {WeekReservationsComponent} from "@modules/reservations/components/week-reservations/week-reservations.component";
import {MyReservationsComponent} from "@modules/reservations/components/my-reservations/my-reservations.component";
import {GenerateReservationsComponent} from "@modules/reservations/components/generate-reservations/generate-reservations.component";


export const components = [
    CourtReservationsComponent,WeekReservationsComponent,MyReservationsComponent,GenerateReservationsComponent
];

export * from './court-reservations/court-reservations.component';
export * from './week-reservations/week-reservations.component';
export * from './my-reservations/my-reservations.component';
export * from './generate-reservations/generate-reservations.component';

