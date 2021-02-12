import {Injectable} from '@angular/core';
import {Member, WeekDay} from "@common/models";

@Injectable()
export class InMemoryDataStore {


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


}


