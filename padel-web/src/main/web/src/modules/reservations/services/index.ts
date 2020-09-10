import {FakeReservationService} from "@modules/reservations/services/fake-reservation.service";
import {ReservationService} from "@modules/reservations/services/reservation.service";

export const services = [FakeReservationService,ReservationService];

export * from './fake-reservation.service';
export * from './reservation.service';
