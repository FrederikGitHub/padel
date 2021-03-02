import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {select, Store} from "@ngrx/store";
import {selectCourtState} from "@modules/admin/reducers";
import {Court} from "@common/models";

@Component({
    selector: 'padel-court-list-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './court-list-container.component.html',
})
export class CourtListContainerComponent implements OnInit {


    courts$ = this.store.pipe(select(selectCourtState));


    constructor(private store: Store<{ courts: Court[] }>) {

    }

    ngOnInit() {
        this.store.dispatch({type: 'Retrieve all courts'});
    }
}
