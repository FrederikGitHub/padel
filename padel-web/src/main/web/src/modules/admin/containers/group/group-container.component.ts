import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {Group} from "@common/models";
import {Store} from "@ngrx/store";

@Component({
    selector: 'padel-group-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './group-container.component.html',
})
export class GroupContainerComponent implements OnInit {
    constructor(private store: Store<{ group: Group }>) {
    }

    ngOnInit() {
    }

    updateGroup(group: Group) {
        if (group.id == -1) {
            this.store.dispatch({type: 'Add group', group: group});
        } else {
            this.store.dispatch({type: 'Update group', group: group});
        }
    }

    removeGroup(group: Group) {
        this.store.dispatch({type: 'Remove group', group: group});
    }
}
