import {Injectable} from '@angular/core';
import {Court, Group, Member, PlayState, Poule, ReservationType, TimeSlot, WeekDay} from "@common/models";

@Injectable()
export class InMemoryDataStore {


    private timeslots: TimeSlot[] = [
        {
            weekday: {"id": 4, "dayOfWeek": 4, "name": "Donderdag",},
            from: "18:30",
            to: "20:00",
            court: {"id": 1, "name": "Padel 1",},
        },
        {
            weekday: {"id": 4, "dayOfWeek": 4, "name": "Donderdag",},
            from: "20:00",
            to: "21:30",
            court: {"id": 1, "name": "Padel 1",},
        },
        {
            weekday: {"id": 4, "dayOfWeek": 4, "name": "Donderdag",},
            from: "21:30",
            to: "23:00",
            court: {"id": 1, "name": "Padel 1",},
        },
    ];

    private weekdays: WeekDay[] = [
        {
            "id": 1,
            "dayOfWeek": 1,
            "name": "Maandag",
        },
        {
            "id": 2,
            "dayOfWeek": 2,
            "name": "Dinsdag",
        },
        {
            "id": 3,
            "dayOfWeek": 3,
            "name": "Woensdag",
        },
        {
            "id": 4,
            "dayOfWeek": 4,
            "name": "Donderdag",
        },
        {
            "id": 5,
            "dayOfWeek": 5,
            "name": "Vrijdag",
        },
        {
            "id": 6,
            "dayOfWeek": 6,
            "name": "Zaterdag",
        },
        {
            "id": 7,
            "dayOfWeek": 7,
            "name": "Zondag",
        }
    ];

    private poules: Poule[] = [
        {
            "id": 1,
            "name": "Poule 1",
        },
        {
            "id": 2,
            "name": "Poule 2",
        },
        {
            "id": 3,
            "name": "Poule 3",
        },
        {
            "id": 4,
            "name": "Poule 4",
        },
        {
            "id": 5,
            "name": "Poule 5",
        },
        {
            "id": 6,
            "name": "Poule 6",
        },
        {
            "id": 7,
            "name": "Poule 7",
        },
        {
            "id": 8,
            "name": "Poule 8",
        },
        {
            "id": 9,
            "name": "Poule 9",
        },
        {
            "id": 10,
            "name": "Poule 10",
        },
        {
            "id": 11,
            "name": "Poule 11",
        },
        {
            "id": 12,
            "name": "Poule 12",
        },
        {
            "id": 13,
            "name": "Poule 13",
        },
        {
            "id": 14,
            "name": "Poule 14",
        },
        {
            "id": 15,
            "name": "Poule 15",
        },
        {
            "id": 16,
            "name": "Poule 2",
        },
        {
            "id": 17,
            "name": "Poule 17",
        },
        {
            "id": 18,
            "name": "Poule 18",
        },
        {
            "id": 19,
            "name": "Poule 19",
        },
        {
            "id": 20,
            "name": "Poule 20",
        },
        {
            "id": 21,
            "name": "Poule 21",
        }
    ];

    private reservationTypes: ReservationType[] = [
        {
            "id": 1,
            "name": "FIXED",
        },
        {
            "id": 2,
            "name": "Poule",
        },

    ];

    private groups: PlayState[] = [
        {
            "id": 1,
            "name": "LOVERS",
        },
        {
            "id": 2,
            "name": "RAKKERS",
        }
    ];

    private playStates: PlayState[] = [
        {
            "id": 1,
            "name": "TO_BE_SCHEDULED",
        },
        {
            "id": 2,
            "name": "SCHEDULED",
        },
        {
            "id": 3,
            "name": "PLAYED",
        },

    ];

    private courts: Court[] = [
        {
            "id": 1,
            "name": "Padel 1",
        },
        {
            "id": 2,
            "name": "Padel 2",
        },
    ];

    private members: Member[] = [
        {
            "id": 1,
            "name": "Van Heddeghem",
            "firstName": "Frederik",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0472761287",
            "active": "y"
        },
        {
            "id": 2,
            "name": "Demil",
            "firstName": "Dirk",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0498939468",
            "active": "Y"
        },
        {
            "id": 3,
            "name": "Dhose",
            "firstName": "Kris",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0478445328",
            "active": "Y"
        },
        {
            "id": 4,
            "name": "Verplanken",
            "firstName": "Kristof",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0473555233",
            "active": "Y"
        },
        {
            "id": 5,
            "name": "Leroy",
            "firstName": "Pedro",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0475838998",
            "active": "Y"
        },
        {
            "id": 6,
            "name": "Cappeleman",
            "firstName": "Philip",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0473599900",
            "active": "Y"
        },
        {
            "id": 7,
            "name": "Van Wymeersch",
            "firstName": "Tim",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0472123958",
            "active": "Y"
        },
        {
            "id": 8,
            "name": "Vanhee",
            "firstName": "Kris",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0476452082",
            "active": "Y"
        },
        {
            "id": 9,
            "name": "Goossens",
            "firstName": "Werner",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0477788935",
            "active": "Y"
        },
        {
            "id": 10,
            "name": "Van De Velde",
            "firstName": "Tom",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0471918411",
            "active": "Y"
        }
        ,
        {
            "id": 11,
            "name": "Verstichelen",
            "firstName": "Davy",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0472334681",
            "active": "Y"
        },
        {
            "id": 12,
            "name": "Stalpaert",
            "firstName": "Bart",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0473208004",
            "active": "Y"
        },
        {
            "id": 13,
            "name": "De Smedt",
            "firstName": "Domonique",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0496901449",
            "active": "Y"
        },
        {
            "id": 14,
            "name": "Torrekens",
            "firstName": "Bruno",
            "email": "frederik.vanheddeghem@gmail.com",
            "gsm": "0473259427",
            "active": "Y"
        }
    ];

    constructor() {
    }


    getMembers(): Member[] {
        return this.members;
    }

    getCourts(): Court[] {
        return this.courts;
    }

    getGroups(): Group[] {
        return this.groups;
    }

    getPoules(): Poule[] {
        return this.poules;
    }

    getPlayStates(): Poule[] {
        return this.playStates;
    }

    getWeekDays(): WeekDay[] {
        return this.weekdays;
    }

    getReservationTypes(): ReservationType[] {
        return this.reservationTypes;
    }

    getTimeSlots(): TimeSlot[] {
        return this.timeslots;
    }


}


