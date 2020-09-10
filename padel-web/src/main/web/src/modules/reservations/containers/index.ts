import {CourtReservationsContainerComponent} from "./court-reservations/court-reservations-container.component";
import {WeekReservationsContainerComponent} from "@modules/reservations/containers/week-reservations/week-reservations-container.component";
import {MyReservationsContainerComponent} from "@modules/reservations/containers/my-reservations/my-reservations-container.component";
import {AutoGenerateReservationsContainerComponent} from "@modules/reservations/containers/auto-generate-reservations/auto-generate-reservations-container.component";


export const containers = [CourtReservationsContainerComponent,WeekReservationsContainerComponent,MyReservationsContainerComponent,AutoGenerateReservationsContainerComponent];

export * from './court-reservations/court-reservations-container.component';
export * from './week-reservations/week-reservations-container.component';
export * from './my-reservations/my-reservations-container.component';
export * from './auto-generate-reservations/auto-generate-reservations-container.component';

