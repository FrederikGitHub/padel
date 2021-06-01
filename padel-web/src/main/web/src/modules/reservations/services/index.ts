import {FakeReservationService} from "@modules/reservations/services/fake-reservation.service";
import {ReservationService} from "@modules/reservations/services/reservation.service";
import {ReservationDataResolverService} from "@modules/reservations/services/reservation-data-resolver";
import {PlanningService} from "@modules/reservations/services/planning.service";
import {CourtReservationDataResolverService} from "@modules/reservations/services/court-reservation-data-resolver";

export const services = [FakeReservationService,ReservationService,ReservationDataResolverService,PlanningService,CourtReservationDataResolverService];

export * from './fake-reservation.service';
export * from './reservation.service';
export * from './planning.service';
export * from './reservation-data-resolver';
export * from './court-reservation-data-resolver';
