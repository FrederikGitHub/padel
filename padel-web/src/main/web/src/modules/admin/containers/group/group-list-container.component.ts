import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {select, Store} from "@ngrx/store";
import {selectGroupState} from "@modules/admin/reducers";
import {Group} from "@common/models";

@Component({
    selector: 'padel-group-list-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './group-list-container.component.html',
})
export class GroupListContainerComponent implements OnInit {



    groups$ = this.store.pipe(select(selectGroupState));


    constructor(private store: Store<{ groups: Group[] }>) {
        //this.members$ = this.store.pipe(select(fromSettings.selectSettings));
    }

    ngOnInit() {
        /*this.memberService
            .getAllMembers()
            .subscribe((members) => this.store.dispatch(LoadMembersSuccess({members})));*/
        this.store.dispatch({ type: 'Retrieve all groups' });
    }
}
