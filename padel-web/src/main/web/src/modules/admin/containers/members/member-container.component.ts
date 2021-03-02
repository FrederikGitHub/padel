import {ChangeDetectionStrategy, Component, OnInit, SimpleChanges} from '@angular/core';
import {Member} from "@common/models";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
    selector: 'padel-member-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './member-container.component.html',
})
export class MemberContainerComponent implements OnInit {


    constructor(private router: Router,private route: ActivatedRoute) {


    }



    ngOnInit() {
        let memberId: string | null= this.route.snapshot.paramMap.get('memberId');
        console.log("memberId" + memberId)

        /*setTimeout(x => {
            this.gridApi.sizeColumnsToFit();
        }, 0);*/

    }





    updateMember(member: Member) {
        //this.store.dispatch(new UpdateSettingsAction(settings));
    }


    ngOnDestroy(): void {
    }

    ngOnChanges(changes: SimpleChanges): void {

    }
}
