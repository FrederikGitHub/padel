import {ChangeDetectionStrategy, Component, OnInit, SimpleChanges} from '@angular/core';
import {Court, Member} from "@common/models";
import {ActivatedRoute, Router} from "@angular/router";
import {Store} from "@ngrx/store";

@Component({
    selector: 'padel-member-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './member-container.component.html',
})
export class MemberContainerComponent implements OnInit {


    constructor(private router: Router,private route: ActivatedRoute,private store: Store<{ courts: Court[] }>) {


    }



    ngOnInit() {
        let memberId: string | null= this.route.snapshot.paramMap.get('memberId');
        console.log("memberId" + memberId)

        /*setTimeout(x => {
            this.gridApi.sizeColumnsToFit();
        }, 0);*/

    }





    updateMember(member: Member) {
        if (member.id == -1){
            this.store.dispatch({ type: 'Add member',member:member});
        }else{
            this.store.dispatch({ type: 'Update member',member:member});
        }
    }





    ngOnDestroy(): void {
    }

    ngOnChanges(changes: SimpleChanges): void {

    }
}
