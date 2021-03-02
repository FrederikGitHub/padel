import {MemberListContainerComponent} from "./members/member-list-container.component";
import {MemberContainerComponent} from "./members/member-container.component";
import {GroupContainerComponent} from "./group/group-container.component";
import {PouleContainerComponent} from "./poule/poule-container.component";
import {TimeslotListContainerComponent} from "./timeslots/timeslot-list-container.component";
import {CourtContainerComponent} from "@modules/admin/containers/court/court-container.component";
import {GroupListContainerComponent} from "@modules/admin/containers/group/group-list-container.component";
import {CourtListContainerComponent} from "@modules/admin/containers/court/court-list-container.component";
import {TimeSlotContainerComponent} from "@modules/admin/containers/timeslots/timeslot-container.component";


export const containers = [MemberListContainerComponent,MemberContainerComponent,CourtContainerComponent,GroupContainerComponent,PouleContainerComponent,GroupContainerComponent,GroupListContainerComponent,CourtContainerComponent,CourtListContainerComponent,TimeSlotContainerComponent,TimeslotListContainerComponent];

export * from './members/member-list-container.component';
export * from './members/member-container.component';
export * from './court/court-container.component';
export * from './group/group-container.component';
export * from './group/group-list-container.component';
export * from './poule/poule-container.component';
export * from './timeslots/timeslot-list-container.component';
export * from './timeslots/timeslot-container.component';
export * from './court/court-container.component';
export * from './court/court-list-container.component';
