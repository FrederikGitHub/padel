import {createFeatureSelector, createSelector} from '@ngrx/store';
import * as fromMembers from './member.reducer';
import * as fromGroups from './group.reducer';
import * as fromCourts from './court.reducer';
import * as fromTimeSlots from './timeslot.reducer';
import * as fromAvailabilities from './availability.reducer';
import * as fromRoot from '../../../app/reducers';
import {Availability, Court, Group, Member, TimeSlot} from "@common/models";

export interface AdminState {
    members: ReadonlyArray<Member>;
    groups: ReadonlyArray<Group>;
    courts: ReadonlyArray<Court>;
    timeslots: ReadonlyArray<TimeSlot>;
    availabilities: ReadonlyArray<Availability>;
}

export interface State extends fromRoot.State {
    admin: AdminState;
}

export const reducers = {
    members: fromMembers.memberReducer,
    groups: fromGroups.groupReducer,
    courts: fromCourts.courtReducer,
    timeslots: fromTimeSlots.timeSlotReducer,
    availabilities: fromAvailabilities.availabilityReducer

};

export const selectAdminState = createFeatureSelector<AdminState>('admin');

export const selectMemberState = createSelector(
    selectAdminState,
    (state: AdminState) => state.members
);

export const selectGroupState = createSelector(
    selectAdminState,
    (state: AdminState) => state.groups
);

export const selectCourtState = createSelector(
    selectAdminState,
    (state: AdminState) => state.courts
);

export const selectTimeSlotState = createSelector(
    selectAdminState,
    (state: AdminState) => state.timeslots
);

export const selectAvailabilityState = createSelector(
    selectAdminState,
    (state: AdminState) => state.availabilities
);



