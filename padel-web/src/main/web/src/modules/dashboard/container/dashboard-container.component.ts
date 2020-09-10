import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-dashboard-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './dashboard-container.component.html',

})
export class DashBoardContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
