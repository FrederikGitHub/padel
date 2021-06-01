import { AppCommonService } from './app-common.service';
import {InMemoryDataStore} from "@common/services/in-memory-data-store.service";
import {RouteData} from "@common/services/route-data.service";
import {MemberService} from "@common/services/member.service";
import {GroupService} from "@common/services/group.service";
import {CourtTimeSlotService} from "@common/services/court-timeslot.service";
import {AvailabilityService} from "@common/services/availability.service";
import {CourtService} from "@common/services/court.service";
import {TimeSlotService} from "@common/services/timeslot.service";

export const services = [AppCommonService,InMemoryDataStore,RouteData,MemberService,GroupService,CourtTimeSlotService,AvailabilityService,CourtService,TimeSlotService];

export * from './app-common.service';
export * from './in-memory-data-store.service';
export * from './member.service';
export * from './group.service';
export * from './availability.service';
export * from './court.service';
export * from './timeslot.service';
export * from './court-timeslot.service';
