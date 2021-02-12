export interface Court {
    id?: number;
    name?: string;
}

export interface Availability {
    label?: string;
    weekNumbers?: number[];
}

export interface Group {
    id?: number;
    name?: string;
    genders?: string[];
}

export interface GroupAvailability {
    weekNumbersOfMonth?: number[];
    group?: Group[];
}

export interface Member {
    id?: number;
    name?: string;
    firstName?: string;
    email?: string;
    gsm?: string;
    level?: string;
    active?: string;
    groupAvailabilityList?: GroupAvailability;
}

export interface CourtTimeSlot {
    id?: number;
    timeSlot?: TimeSlot;
    court?: Court;
}


export interface Reservation {
    id?: number;
    day?: number;
    month?: number;
    year?: number;
    week?: number;
    courtTimeSlot?: CourtTimeSlot;
    reservationMembers?: Member[];
    reserveMembers?: Member[];
    group?: Group[];
}

export interface ReservationType {
    name?: string;
}

export interface DayOfWeek {

}

export interface TimeSlot {
    from?: string;
    to?: string;
    dayOfWeek?: DayOfWeek;
}

export interface Week {
    weekOfYear?: string;
    weekOfMonth?: string;
    startWeekDay?: string;
    endWeekDay?: string;
    year?: number;

}

export interface WeekDay {
    id?: number;
    dayOfWeek?: number;
    name?: string;
}

export interface WeekPlanning {
    week?: number;
    reservationList?: Reservation[];
    reserveList?: Member[];
}

export interface WeekTimeSlot {
    day?: number;
    timeslot?: CourtTimeSlot;
    week?: Week;
}

export interface MemberFilterForm {
    name?: string;
    firstName?: string;
    level?: string;
    group?:string;
}
