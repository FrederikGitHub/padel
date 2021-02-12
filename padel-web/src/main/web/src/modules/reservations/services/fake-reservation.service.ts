import {WeekPlanning} from "@common/models";
import {InMemoryDataStore} from "@common/services/in-memory-data-store.service";
import {Injectable} from "@angular/core";
import {Observable, of} from "rxjs";

@Injectable()
//export class FakeReservationService implements InMemoryDbService {
export class FakeReservationService  {



    constructor(private inMemoryDataStore:InMemoryDataStore) {

    }

    /*createDb() {

        let week_reservations: WeekPlanning[] = [
            {
                id: 1,
                weekNr: 1,
                from: "04/01/2021",
                to: "11/01/2021",
                timeSlotReservations:[
                    {id:1,day:7,month:1,year:2021,week:1,timeSlot:this.inMemoryDataStore.getTimeSlots()[0],reservationMembers:[this.inMemoryDataStore.getMembers()[0],this.inMemoryDataStore.getMembers()[1],this.inMemoryDataStore.getMembers()[2],this.inMemoryDataStore.getMembers()[3]],reservationType:this.inMemoryDataStore.getReservationTypes()[0]},
                    {id:1,day:7,month:1,year:2021,week:1,timeSlot:this.inMemoryDataStore.getTimeSlots()[1],reservationMembers:[this.inMemoryDataStore.getMembers()[4],this.inMemoryDataStore.getMembers()[5],this.inMemoryDataStore.getMembers()[6],this.inMemoryDataStore.getMembers()[7]],reservationType:this.inMemoryDataStore.getReservationTypes()[0]},
                    {id:1,day:7,month:1,year:2021,week:1,timeSlot:this.inMemoryDataStore.getTimeSlots()[2],reservationMembers:[this.inMemoryDataStore.getMembers()[8],this.inMemoryDataStore.getMembers()[9],this.inMemoryDataStore.getMembers()[10],this.inMemoryDataStore.getMembers()[11]],reservationType:this.inMemoryDataStore.getReservationTypes()[0]}
                    ],
                reserveList:[this.inMemoryDataStore.getMembers()[12],this.inMemoryDataStore.getMembers()[13]]
            },
            {
                id: 2,
                weekNr: 2,
                from: "11/01/2021",
                to: "18/01/2021",
                timeSlotReservations:[
                    {id:1,day:7,month:1,year:2021,week:1,timeSlot:this.inMemoryDataStore.getTimeSlots()[0],reservationMembers:[this.inMemoryDataStore.getMembers()[12],this.inMemoryDataStore.getMembers()[13],this.inMemoryDataStore.getMembers()[2],this.inMemoryDataStore.getMembers()[3]],reservationType:this.inMemoryDataStore.getReservationTypes()[0]},
                    {id:1,day:7,month:1,year:2021,week:1,timeSlot:this.inMemoryDataStore.getTimeSlots()[1],reservationMembers:[this.inMemoryDataStore.getMembers()[4],this.inMemoryDataStore.getMembers()[5],this.inMemoryDataStore.getMembers()[6],this.inMemoryDataStore.getMembers()[7]],reservationType:this.inMemoryDataStore.getReservationTypes()[0]},
                    {id:1,day:7,month:1,year:2021,week:1,timeSlot:this.inMemoryDataStore.getTimeSlots()[2],reservationMembers:[this.inMemoryDataStore.getMembers()[8],this.inMemoryDataStore.getMembers()[9],this.inMemoryDataStore.getMembers()[10],this.inMemoryDataStore.getMembers()[11]],reservationType:this.inMemoryDataStore.getReservationTypes()[0]}
                ],
                reserveList:[this.inMemoryDataStore.getMembers()[0],this.inMemoryDataStore.getMembers()[1]]
            },
        ];
        return {
            week: week_reservations
        };
    }


    getWeekReservations$():Observable<WeekPlanning[]>{
        let weekPlannings: WeekPlanning[] = [
            {
                id: 1,
                weekNr: 1,
                from: "04/01/2021",
                to: "11/01/2021",
                timeSlotReservations:[
                    {id:1,day:7,month:1,year:2021,week:1,timeSlot:this.inMemoryDataStore.getTimeSlots()[0],reservationMembers:[this.inMemoryDataStore.getMembers()[0],this.inMemoryDataStore.getMembers()[1],this.inMemoryDataStore.getMembers()[2],this.inMemoryDataStore.getMembers()[3]],reservationType:this.inMemoryDataStore.getReservationTypes()[0]},
                    {id:1,day:7,month:1,year:2021,week:1,timeSlot:this.inMemoryDataStore.getTimeSlots()[1],reservationMembers:[this.inMemoryDataStore.getMembers()[4],this.inMemoryDataStore.getMembers()[5],this.inMemoryDataStore.getMembers()[6],this.inMemoryDataStore.getMembers()[7]],reservationType:this.inMemoryDataStore.getReservationTypes()[0]},
                    {id:1,day:7,month:1,year:2021,week:1,timeSlot:this.inMemoryDataStore.getTimeSlots()[2],reservationMembers:[this.inMemoryDataStore.getMembers()[8],this.inMemoryDataStore.getMembers()[9],this.inMemoryDataStore.getMembers()[10],this.inMemoryDataStore.getMembers()[11]],reservationType:this.inMemoryDataStore.getReservationTypes()[0]}
                ],
                reserveList:[this.inMemoryDataStore.getMembers()[12],this.inMemoryDataStore.getMembers()[13]]
            },
            {
                id: 2,
                weekNr: 2,
                from: "11/01/2021",
                to: "18/01/2021",
                timeSlotReservations:[
                    {id:1,day:7,month:1,year:2021,week:1,timeSlot:this.inMemoryDataStore.getTimeSlots()[0],reservationMembers:[this.inMemoryDataStore.getMembers()[12],this.inMemoryDataStore.getMembers()[13],this.inMemoryDataStore.getMembers()[2],this.inMemoryDataStore.getMembers()[3]],reservationType:this.inMemoryDataStore.getReservationTypes()[0]},
                    {id:1,day:7,month:1,year:2021,week:1,timeSlot:this.inMemoryDataStore.getTimeSlots()[1],reservationMembers:[this.inMemoryDataStore.getMembers()[4],this.inMemoryDataStore.getMembers()[5],this.inMemoryDataStore.getMembers()[6],this.inMemoryDataStore.getMembers()[7]],reservationType:this.inMemoryDataStore.getReservationTypes()[0]},
                    {id:1,day:7,month:1,year:2021,week:1,timeSlot:this.inMemoryDataStore.getTimeSlots()[2],reservationMembers:[this.inMemoryDataStore.getMembers()[8],this.inMemoryDataStore.getMembers()[9],this.inMemoryDataStore.getMembers()[10],this.inMemoryDataStore.getMembers()[11]],reservationType:this.inMemoryDataStore.getReservationTypes()[0]}
                ],
                reserveList:[this.inMemoryDataStore.getMembers()[0],this.inMemoryDataStore.getMembers()[1]]
            },
        ];
        return of(weekPlannings);

    }*/
}
