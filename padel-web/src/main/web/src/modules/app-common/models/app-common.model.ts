export interface Court {
    id?: number;
    name?: string;
}

export interface Group {
    id?: number;
    name?: string;
}

export interface Poule {
    id?: number;
    name?: string;
}

export interface WeekDay {
    id?: number;
    dayOfWeek?: number;
    name?: string;
}

export interface TimeSlot {
    weekday?: WeekDay;
    from?: string;
    to?: string;
    court?: Court;
}

export interface Member {
    id?: number;
    name?: string;
    firstName?: string;
    email?: string;
    gsm?: string;
    group?: Group;
    active?: string;
}

export interface ReservationType {
    id?: number;
    name?: string;
}

export interface Reservation {
    id?: number;
    day?: number;
    month?: number;
    year?: number;
    week?: number;
    timeSlot?: TimeSlot;
    reservationMembers?: Member[];
    reservationType?: ReservationType;
}

export interface WeekPlanning {
    id?: number;
    weekNr?: number;
    from?: string;
    to?: string;
    timeSlotReservations?: Reservation[];
    reserveList?:Member[];
}

export interface PlayState {
    id?: number;
    name?:string
}

export interface PouleTour {
    id?: number;
    from?: string;
    to?: string;
    state?:PlayState;
    pouleTourGames:PouleTourGame[];
}

export interface PouleTourGame {
    id?: number;
    pouleTour?: PouleTour;
    poule?: Poule;
    state?:PlayState;
    pouleTourGameMembers:PouleTourGameMember[];
}

export interface PouleTourGameMember {
    id?: number;
    pouleTourGame:PouleTourGame;
    member?: Member;
    points?: number;
}
