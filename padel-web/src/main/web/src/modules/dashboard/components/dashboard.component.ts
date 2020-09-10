import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-dashboard',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './dashboard.component.html',

})
export class DashBoardComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
