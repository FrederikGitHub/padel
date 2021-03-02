import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {Member} from "@common/models";
import {select, Store} from "@ngrx/store";
import {MemberService} from "@modules/admin/services/member.service";
import {selectMemberState} from "@modules/admin/reducers";
import {take} from "rxjs/operators";

@Component({
    selector: 'padel-member-list-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './member-list-container.component.html',
})
export class MemberListContainerComponent implements OnInit {



    members$ = this.store.pipe(select(selectMemberState));




    constructor(private memberService:MemberService,private store: Store<{ members: Member[] }>) {
        //this.members$ = this.store.pipe(select(fromSettings.selectSettings));
    }

    ngOnInit() {
        /*this.memberService
            .getAllMembers()
            .subscribe((members) => this.store.dispatch(LoadMembersSuccess({members})));*/
        this.store.dispatch({ type: 'Retrieve all members' });
        //this.members$.pipe(take(1)).subscribe();
    }
}
