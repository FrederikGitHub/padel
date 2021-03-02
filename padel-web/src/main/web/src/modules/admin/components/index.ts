import {MemberListComponent} from "./members/member-list.component";
import {CourtComponent} from "./court/court.component";
import {PouleComponent} from "./poule/poule.component";
import {TimeSlotComponent} from "./timeslots/timeslots.component";
import {GroupComponent} from "@modules/admin/components/group/group.component";
import {MemberComponent} from "@modules/admin/components/members/member.component";
import {GroupListComponent} from "@modules/admin/components/group/group-list.component";
import {CourtListComponent} from "@modules/admin/components/court/court-list.component";
import {TimeSlotListComponent} from "@modules/admin/components/timeslots/timeslot-list.component";

export const components = [MemberListComponent,MemberComponent,CourtComponent,MemberListComponent,PouleComponent,TimeSlotComponent,GroupComponent,GroupListComponent,CourtComponent,CourtListComponent,TimeSlotListComponent];

export * from './members/member-list.component';
export * from './members/member.component';
export * from './court/court.component';
export * from './group/group.component';
export * from './group/group-list.component';
export * from './members/member-list.component';
export * from './timeslots/timeslots.component';
export * from './timeslots/timeslot-list.component';
export * from './court/court.component';
export * from './court/court-list.component';


