import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {Court} from "@common/models";
import {Store} from "@ngrx/store";

@Component({
    selector: 'padel-court-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './court-container.component.html',
})
export class CourtContainerComponent implements OnInit {
    constructor(private store: Store<{ court: Court }>) {
    }

    ngOnInit() {
    }

    updateCourt(court: Court) {
        if (court.id == -1) {
            this.store.dispatch({type: 'Add court', court: court});
        } else {
            this.store.dispatch({type: 'Update court', court: court});
        }
    }
}
