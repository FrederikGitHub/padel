import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import {Court, Member, PlanningRequest} from "@common/models";
import {ActivatedRoute, Router} from "@angular/router";
import {Store} from "@ngrx/store";

@Component({
    selector: 'padel-auto-generate-reservations-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './auto-generate-reservations-container.component.html',
    styleUrls: ['auto-generate-reservations-container.component.scss'],
})
export class AutoGenerateReservationsContainerComponent implements OnInit {

    constructor(private router: Router,private route: ActivatedRoute,private store: Store) {


    }

    ngOnInit() {}

    generatePlanning(planningRequest: PlanningRequest) {
        this.store.dispatch({ type: 'Generate planning',planningRequest:planningRequest});
        /*if (member.id == -1){

        }else{
            this.store.dispatch({ type: 'Update member',member:member});
        }*/
    }
}
